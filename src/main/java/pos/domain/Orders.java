package pos.domain;

import pos.view.OutputView;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Orders {
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
        int paymentMoney = Payment.calculatePaymentAmount(this, payType);
        OutputView.payTotalMoney(paymentMoney);
        orders.clear();
    }

    public int calculateTotalMoney() {
        return orders.keySet().stream().mapToInt(key -> key.getPrice() * orders.get(key).getMenuCnt()).sum();
    }

    public int getChickenCnt() {
        return orders.keySet().stream().filter(menu -> menu.getCategory() == Category.CHICKEN).mapToInt(menu -> orders.get(menu).getMenuCnt()).sum();
    }
}

