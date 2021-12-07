package domain;

import view.OutputView;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

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

    public void payTotalMoney() {
        AtomicInteger totalMoney = new AtomicInteger();
        orders.forEach((menu, menuCnt) -> totalMoney.addAndGet(menu.getPrice() * menuCnt.getMenuCnt()));
        OutputView.payTotalMoney(totalMoney);
        orders.clear();
    }
}

