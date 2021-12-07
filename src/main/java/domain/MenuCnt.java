package domain;

public class MenuCnt {
	private int menuCnt;
	public MenuCnt(int menuCnt) {
		if (menuCnt < 0 || menuCnt > 99) {
			throw new IllegalArgumentException("해당 개수만큼 주문할 수 없습니다.");
		}
		this.menuCnt = menuCnt;
	}

	public static MenuCnt add(MenuCnt existingCnt, MenuCnt orderCnt) {
		return new MenuCnt(existingCnt.getMenuCnt() + orderCnt.getMenuCnt());
	}

	public int getMenuCnt() {
		return menuCnt;
	}
}
