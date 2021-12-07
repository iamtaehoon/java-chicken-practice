package domain;

import java.util.Arrays;

import sun.invoke.empty.Empty;

public class Table {
    private final int number;
    private Orders orders = new Orders();

    public Table(final int number) {
        this.number = number;
    }

    public void pay() {
        // orders의 메서드를 사용해 한개한개 목록들을 보여준다.
        orders.showBills();
        // 목록들의 개수와 금액을 곱한걸 보여준다.
        // orders를 clear 한다.
    }

    public void takeOrder(String menuInput, String orderCntInput) {
        //TODO 메뉴와 주문개수를 검증하는 로직 나중에 분리
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
