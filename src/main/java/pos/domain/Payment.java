package pos.domain;

public class Payment {
    public static int calculatePaymentAmount(Orders orders, PayType payType) {
        int discountMoney = 0;
        int totalMoney = orders.calculateTotalMoney();
        discountMoney += (orders.getChickenCnt()/10)*10000;
        totalMoney -= discountMoney;

        if (payType == PayType.CASH) {
            discountMoney += discountCash(totalMoney);
            totalMoney -= discountMoney;
        }
        return totalMoney;
    }

    private static int discountCash(int totalMoney) {
        return totalMoney * 5 / 100;
    }
}
