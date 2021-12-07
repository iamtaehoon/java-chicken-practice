package domain;

import java.util.LinkedHashMap;

public class Orders { //주문서
	private LinkedHashMap<Menu, MenuCnt> orders = new LinkedHashMap<Menu, MenuCnt>();

	public void record(Menu menu, MenuCnt orderCnt) {
		if (orders.containsKey(menu)) {
			MenuCnt existingCnt = orders.get(menu);
			MenuCnt totalCnt = MenuCnt.add(existingCnt, orderCnt);
			orders.put(menu, totalCnt);
			return;
		}
		orders.put(menu, orderCnt);
	}
}

