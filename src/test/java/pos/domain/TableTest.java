package pos.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TableTest { //테이블 단위로 주문이 들어가는 걸 테스트해준다.

    // TODO 제대로 만들어졌나, 눈으로 검사해보려고 만든 테스트. 나중에 리팩토링 해야함
    @Test
    @DisplayName("테이블 여러개에 주문이 들어가도, 내 테이블의 것만 Bills를 확인할 수 있어야 한다.")
    void 여러_테이블에_주문_하나의_테이블_결과_확인() {
        Table table1 = new Table(1);
        Table table5 = new Table(5);
        table1.takeOrder("1", "2");
        table5.takeOrder("2", "3");
        table5.takeOrder("21", "4");
        table1.takeOrder("21", "4");
        table1.pay();
        table5.pay();
    }

    @Test
    @DisplayName("계산되고 나서 테이블의 bills가 초기화되었는가 확인한다.")
    void 계산이후_빌즈_초기화() {
        Table table1 = new Table(1);
        table1.takeOrder("1", "2");
        table1.takeOrder("21", "4");
        table1.pay();
        table1.pay();
    }
}