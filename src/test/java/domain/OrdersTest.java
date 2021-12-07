package domain;

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
		OrderCnt orderCnt = new OrderCnt(10);

		order.record(menu, orderCnt);
	}

	@Test
	@DisplayName("기존 개수에서 추가로 주문이 들어왔을 때 개수 제한을 안넘기면 정상 로직이 돌아간다.")
	void 메뉴_추가주문_개수_초과_정상() {
		Orders order = new Orders();
		Menu menu = Menu.SEASONED;
		OrderCnt orderCnt = new OrderCnt(70);
		order.record(menu, orderCnt);
		OrderCnt additionalOrderCnt = new OrderCnt(20);

		order.record(menu, additionalOrderCnt);
	}

	@Test
	@DisplayName("기존 개수에서 추가로 주문이 들어왔을 때 개수 제한을 넘기면 오류를 발생시킨다.")
	void 메뉴_추가주문_개수_초과_오류() {
		Orders order = new Orders();
		Menu menu = Menu.FRIED;
		OrderCnt orderCnt = new OrderCnt(90);
		order.record(menu, orderCnt);
		OrderCnt additionalOrderCnt = new OrderCnt(20);

		Assertions.assertThatThrownBy(() -> order.record(menu, additionalOrderCnt))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("해당 개수만큼 주문할 수 없습니다.");
	}
}