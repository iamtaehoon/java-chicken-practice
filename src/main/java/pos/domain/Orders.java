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
        int totalMoney = 0;
        for (Menu menu : orders.keySet()) {
            OrderCnt orderCnt = orders.get(menu);
            totalMoney += (menu.getPrice() * orderCnt.getMenuCnt());
        }
        return totalMoney;
    }

    public int discountChickenCnt() {
        AtomicInteger totalChickenCnt = new AtomicInteger();
        orders.forEach((menu, orderCnt) -> {
            if (menu.getCategory() == Category.CHICKEN) {
                totalChickenCnt.addAndGet(orderCnt.getMenuCnt());
            }
        });
        return (totalChickenCnt.get() / 10) * 10000;
    }
}

