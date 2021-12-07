package view;

import domain.Menu;
import domain.OrderCnt;
import domain.Orders;
import domain.Table;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void showBills(LinkedHashMap<Menu, OrderCnt> orders) {
        System.out.println("## 메뉴 수량 금액");
        orders.forEach((menu, menuCnt) -> System.out.println(
                menu.getName() + " " + menuCnt + " " + menu.getPrice() * menuCnt.getMenuCnt()));
    }

    public static void payTotalMoney(AtomicInteger totalMoney) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(totalMoney+"원");
    }

}
