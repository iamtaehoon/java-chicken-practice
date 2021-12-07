package domain;

import java.util.Arrays;

import sun.invoke.empty.Empty;

public class Table {
    private final int number;
    private Orders orders = new Orders();

    public Table(final int number) {
        this.number = number;
    }

    public void takeOrder(String menuInput, String orderCntInput) {
        //메뉴와 주문개수를 여기서 만드는게 맞을까? 일단 만들기.
        Menu menu = Arrays.stream(Menu.values())
            .filter(eachMenu -> eachMenu.getNumber() == Integer.parseInt(menuInput))
            .findAny()
            .orElse(null);
        MenuCnt orderCnt = new MenuCnt(Integer.parseInt(orderCntInput)); //
        orders.record(menu, orderCnt);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
