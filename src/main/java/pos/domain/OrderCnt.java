package pos.domain;

import static pos.Constant.MAX_ORDER_CNT;
import static pos.Constant.MIN_ORDER_CNT;

public class OrderCnt {
    private int menuCnt;
    public OrderCnt(int menuCnt) {
        if (menuCnt < MIN_ORDER_CNT || menuCnt > MAX_ORDER_CNT) {
            throw new IllegalArgumentException("해당 개수만큼 주문할 수 없습니다.");
        }
        this.menuCnt = menuCnt;
    }

    public static OrderCnt add(OrderCnt existingCnt, OrderCnt orderCnt) {
        return new OrderCnt(existingCnt.getMenuCnt() + orderCnt.getMenuCnt());
    }

    public int getMenuCnt() {
        return menuCnt;
    }

    @Override
    public String toString() {
        return Integer.toString(menuCnt);
    }
}
