package pos.domain;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Payment {
    public static int calculatePaymentAmount(LinkedHashMap<Menu, OrderCnt> orders, PayType payType) {
        int discountMoney = 0;
        int totalMoney = calculateTotalMoney(orders);

        discountMoney += discountChickenCnt(orders);
        totalMoney -= discountMoney;

        if (payType == PayType.CASH) {
            discountMoney += discountCash(totalMoney);
        }
        totalMoney -= discountMoney;

        return totalMoney;
    }

    private static int calculateTotalMoney(LinkedHashMap<Menu, OrderCnt> orders) {
        int totalMoney = 0;
        for (Menu menu : orders.keySet()) {
            OrderCnt orderCnt = orders.get(menu);
            totalMoney += (menu.getPrice() * orderCnt.getMenuCnt());
        }
        return totalMoney;
    }

    private static int discountCash(int totalMoney) {
        return totalMoney * 5 / 100;
    }

    private static int discountChickenCnt(LinkedHashMap<Menu, OrderCnt> orders) {
        AtomicInteger totalChickenCnt = new AtomicInteger();
        orders.forEach((menu, orderCnt) -> {
            if (menu.getCategory() == Category.CHICKEN) {
                totalChickenCnt.addAndGet(orderCnt.getMenuCnt());
            }
        });
        return (totalChickenCnt.get() / 10) * 10000;
    }
}
