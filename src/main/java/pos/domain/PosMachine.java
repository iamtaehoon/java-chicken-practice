package pos.domain;

import pos.InputValidator;
import pos.view.InputView;
import pos.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class PosMachine {
    private Table table;

    public void start() {
        try {
            MainCode mainCode = inputMainCode();
            executeFunction(mainCode);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            start();
        }
    }

    private MainCode inputMainCode() {
        int inputCode = InputValidator.validateNumber(InputView.inputFunctionCode());
        return Arrays.stream(MainCode.values())
                .filter(code -> code.getCode() == inputCode)
                .findAny().orElseThrow(() -> new IllegalArgumentException("해당 기능은 존재하지 않습니다."));
    }

    private void executeFunction(MainCode mainCode) {
        if (mainCode == MainCode.REGISTER) {
            register();
        } else if (mainCode == MainCode.PAY) {
            pay();
        } else if (mainCode == MainCode.END) {
            return;
        }
        start();
    }

    private void pay() {
        Table table = determineTables();
        table.pay();
    }

    private void register() {
        Table table = determineTables();
        final List<Menu> menus = Arrays.asList(Menu.values().clone());
        OutputView.printMenus(menus);
        orderMenu(table);
    }

    private void orderMenu(Table table) {
        try {
            final String menuType = InputView.inputMenuType();
            final String orderCnt = InputView.inputOrderCnt();
            table.takeOrder(menuType, orderCnt);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            orderMenu(table);
        }
    }

    private Table determineTables() {
        try {
            final List<Table> tables = TableRepository.tables();
            OutputView.printTables(tables);
            int tableNumber = InputValidator.validateNumber(InputView.inputTableNumber());
            table = TableRepository.tables().stream().filter(table -> table.getNumber() == tableNumber).findAny()
                    .orElseThrow(() -> new IllegalArgumentException("해당 테이블 번호는 존재하지 않습니다."));
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            determineTables();
        }
        return table;
    }
}
