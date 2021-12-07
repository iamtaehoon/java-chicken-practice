package domain;

import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

public class PosMachine {
    MainFunctionCode mainFunctionCode;
    public void start() {
        mainFunctionCode = Arrays.stream(MainFunctionCode.values())
                .filter(code -> code.getCode() == InputView.inputFunction())
                .findFirst().orElse(null);

        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = Arrays.asList(Menu.values().clone());
        OutputView.printMenus(menus);

        final Menu menuType = InputView.inputMenuType();
        final int orderCnt = InputView.inputOrderCnt();
    }
}
