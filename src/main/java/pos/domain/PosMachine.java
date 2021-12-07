package pos.domain;

import pos.view.InputView;
import pos.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class PosMachine {

    public void start() {
        MainFunctionCode mainFunctionCode = inputMainFunctionCode();
        executeFunction(mainFunctionCode);
    }

    private MainFunctionCode inputMainFunctionCode() {
        int inputCode = InputView.inputFunction();
        InputView.removeBlank();
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
        final int tableNumber = InputView.inputTableNumber();
        InputView.removeBlank();
        return TableRepository.tables().get(tableNumber);
    }
}
