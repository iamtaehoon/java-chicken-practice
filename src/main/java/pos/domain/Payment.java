package pos.domain;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Payment {

    public static int calculatePaymentAmount(LinkedHashMap<Menu, OrderCnt> orders, PayType payType) {
        AtomicInteger sumMoney = new AtomicInteger();
        int discountMoney = 0;
        int totalMoney = 0;

        orders.forEach((menu, menuCnt) -> sumMoney.addAndGet((menu.getPrice() * menuCnt.getMenuCnt())));
        totalMoney = sumMoney.get();
        discountMoney += discountChickenCnt(orders);
        totalMoney -= discountMoney;

        if (payType == PayType.CASH) {
            discountMoney += discountCash(totalMoney);
            totalMoney -= discountMoney;
        }
        return discountMoney;
    }

    private static int discountCash(int totalMoney) {
        return totalMoney * 95 / 100;
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
