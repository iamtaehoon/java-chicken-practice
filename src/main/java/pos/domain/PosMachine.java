package pos.domain;

import pos.InputValidator;
import pos.view.InputView;
import pos.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class PosMachine {
    public void start() {
        try {
            MainFunctionCode mainFunctionCode = inputMainFunctionCode();
            executeFunction(mainFunctionCode);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }
    }

    private MainFunctionCode inputMainFunctionCode() {
        int inputCode = InputValidator.validateNumber(InputView.inputFunctionCode());
        return Arrays.stream(MainFunctionCode.values())
                .filter(code -> code.getCode() == inputCode)
                .findAny().orElse(null);
    }

    private void executeFunction(MainFunctionCode mainFunctionCode) { //TODO : 이게 최선일까?
        if (mainFunctionCode == MainFunctionCode.REGISTER) {
            register();
        } else if (mainFunctionCode == MainFunctionCode.PAY) {
            pay();
        } else if (mainFunctionCode == MainFunctionCode.END) {
            return;
        } else {
            throw new IllegalArgumentException("해당 기능은 존재하지 않습니다.");
        }
        start();
    }

    private void pay() {
        Table table = determineTables();
        //결제타입 물어보고 정함.
        table.pay();
    }

    private void register() {
        Table table = determineTables();
        final List<Menu> menus = Arrays.asList(Menu.values().clone());
        OutputView.printMenus(menus);
        orderMenu(table);
    }

    private void orderMenu(Table table) {
        final String menuType = InputView.inputMenuType();
        final String orderCnt = InputView.inputOrderCnt();
        table.takeOrder(menuType, orderCnt);
    }

    private Table determineTables() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        int tableNumber = InputValidator.validateNumber(InputView.inputTableNumber());
        return TableRepository.tables().get(tableNumber);
    }
}
