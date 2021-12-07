package pos.domain;

import pos.InputValidator;
import pos.view.InputView;
import pos.view.OutputView;

import java.util.Arrays;

public class Table {
    private final int number;
    private Orders orders = new Orders();
    private PayType payType;

    public Table(final int number) {
        this.number = number;
    }

    public void pay() {
        orders.showBills();
        OutputView.printBeforePayment(number);
        PayType payType = askPayType();
        orders.payTotalMoney(payType);
    }

    private PayType askPayType() {
        try {
            int inputPayType = InputValidator.validateNumber(InputView.inputPayType());
            payType = Arrays.stream(PayType.values()).filter(payType -> payType.getPayType() == inputPayType)
                    .findAny().orElseThrow(() -> new IllegalArgumentException("해당 결제 타입은 존재하지 않습니다."));
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            askPayType();
        }
        return payType;
    }
    public void takeOrder(String menuInput, String orderCntInput) {
        Menu menu = Arrays.stream(Menu.values())
                .filter(eachMenu -> eachMenu.getNumber() == InputValidator.validateNumber(menuInput))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴는 존재하지 않습니다."));
        OrderCnt orderCnt = new OrderCnt(InputValidator.validateNumber(orderCntInput)); //
        orders.record(menu, orderCnt);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber() {
        return number;
    }
}
