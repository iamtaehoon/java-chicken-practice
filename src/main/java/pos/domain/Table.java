package pos.domain;

import pos.view.InputView;

import java.util.Arrays;

public class Table {
    private final int number;
    private Orders orders = new Orders();

    public Table(final int number) {
        this.number = number;
    }

    public void pay() {
        orders.showBills();
        PayType payType = askPayType();
        orders.payTotalMoney();
    }

    private PayType askPayType() {
        int inputPayType = Integer.parseInt(InputView.inputPayType());
        return Arrays.stream(PayType.values()).filter(payType -> payType.getPayType() == inputPayType).findAny().orElse(null);
    }
    public void takeOrder(String menuInput, String orderCntInput) {
        //TODO 메뉴와 주문개수를 검증하는 로직 나중에 분리
        Menu menu = Arrays.stream(Menu.values())
            .filter(eachMenu -> eachMenu.getNumber() == Integer.parseInt(menuInput))
            .findAny()
            .orElse(null);
        OrderCnt orderCnt = new OrderCnt(Integer.parseInt(orderCntInput)); //
        orders.record(menu, orderCnt);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
