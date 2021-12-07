package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrdersTest {
	@Test
	@DisplayName("존재하는 메뉴를 주문 가능한 수량만큼 주문한다.")
	void 존재하는_메뉴_가능한_개수_주문_정상() {
		//given
		Orders order = new Orders();
		Menu menu = Menu.FRIED;
		MenuCnt orderCnt = new MenuCnt(10);

		order.record(menu, orderCnt);
	}
	//없는 메뉴 -> 오류
	// 개수 99개 초과 -> 오류
	// 있는 메뉴, 기존에 있던 개수 + 추가로 주문 이상없음
	// 있는 메뉴, 기존에 있던거 + 추가 주문, 99개 초과 -> 오류

}