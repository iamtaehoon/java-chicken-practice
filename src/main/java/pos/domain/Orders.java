package pos.domain;

import pos.view.OutputView;

import java.util.LinkedHashMap;

public class Orders { //주문서
    private LinkedHashMap<Menu, OrderCnt> orders = new LinkedHashMap<>();

    public void record(Menu menu, OrderCnt orderCnt) {
        if (orders.containsKey(menu)) {
            OrderCnt existingCnt = orders.get(menu);
            OrderCnt totalCnt = OrderCnt.add(existingCnt, orderCnt);
            orders.put(menu, totalCnt);
            return;
        }
        orders.put(menu, orderCnt);
    }

    public void showBills() {
        OutputView.showBills(orders);
    }

    public void payTotalMoney(PayType payType) {
        int paymentMoney = Payment.calculatePaymentAmount(orders, payType);
        OutputView.payTotalMoney(paymentMoney);
        orders.clear();
    }
}

