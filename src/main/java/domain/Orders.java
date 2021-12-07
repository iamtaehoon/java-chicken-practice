package domain;

import java.util.LinkedHashMap;

public class Orders { //주문서
	private LinkedHashMap<Menu, MenuCnt> orders = new LinkedHashMap<>();

	public void record(Menu menu, MenuCnt orderCnt) {
		if (orders.containsKey(menu)) {
			MenuCnt existingCnt = orders.get(menu);
			MenuCnt totalCnt = MenuCnt.add(existingCnt, orderCnt);
			orders.put(menu, totalCnt);
			return;
		}
		orders.put(menu, orderCnt);
	}

	public void showBills() {
		System.out.println("메뉴 수량 금액");
		orders.forEach((menu, menuCnt) -> System.out.println(
			menu.getName() + " " + menuCnt.getMenuCnt() + " " + menu.getPrice() * menuCnt.getMenuCnt()));
	}
}

