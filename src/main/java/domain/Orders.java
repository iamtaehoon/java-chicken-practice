package domain;

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
		System.out.println("## 메뉴 수량 금액");
		orders.forEach((menu, menuCnt) -> System.out.println(
			menu.getName() + " " + menuCnt + " " + menu.getPrice() * menuCnt.getMenuCnt()));
	}

	public void payTotalMoney() {
		showTotalMoney();
		orders.clear();
	}

	private void showTotalMoney() {
		System.out.println("## 최종 결제할 금액");
		AtomicInteger totalMoney = new AtomicInteger();
		orders.forEach((menu, menuCnt) -> totalMoney.addAndGet(menu.getPrice() * menuCnt.getMenuCnt()));
		System.out.println(totalMoney+"원");
	}
}

