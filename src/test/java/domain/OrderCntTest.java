package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderCntTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 10, 84, 99})
    @DisplayName("주문 수량은 1~최대수량에서 정상적으로 만들어진다.")
    void 주문수량_정상(int cnt) {
        assertThat(new OrderCnt(cnt).getMenuCnt()).isEqualTo(cnt);
    }

    @Test
    @DisplayName("주문 수량은 음수일 수 없다.")
    void 주문수량_음수_오류() {
        assertThatThrownBy(() -> new OrderCnt(-1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 개수만큼 주문할 수 없습니다.");
    }

    @Test
    @DisplayName("주문 수량은 최대수량을 넘어갈 수 없다.")
    void 주문수량_최대치_초과_오류() {
        assertThatThrownBy(() -> new OrderCnt(100)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 개수만큼 주문할 수 없습니다.");
    }


}