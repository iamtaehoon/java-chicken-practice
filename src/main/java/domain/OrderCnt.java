package domain;

public class OrderCnt {
	private int menuCnt;
	public OrderCnt(int menuCnt) {
		if (menuCnt < 0 || menuCnt > 99) {
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
}
