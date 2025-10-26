package racingcar.domain.vo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundTest {
    @Test
    @DisplayName("0 보다 작은 라운드는 예외 발생")
    void less_than_zero_exception() {
        Assertions.assertThatThrownBy(() -> new Round(-1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드는 0이상만 가능합니다");
    }

    @Test
    @DisplayName("0인 라운드는 가능하다")
    void zero_round_possible() {
        Assertions.assertThatCode(() -> new Round(0L))
                .doesNotThrowAnyException();
    }
}
