package domain;

import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

public class PosMachine {
    public void start() {
        InputView.inputFunction();
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = Arrays.asList(Menu.values().clone());
        OutputView.printMenus(menus);

    }
}
