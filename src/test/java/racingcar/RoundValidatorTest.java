package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RoundValidator;

public class RoundValidatorTest {
    @Test
    @DisplayName("숫자만 입력해야 한다.")
    void only_number_applied_trim() {
        RoundValidator.validateNumber("12");
    }

    @Test
    @DisplayName("숫자만 입력해야 한다. 좌, 우측에 존재하는 공백은 허용한다")
    void only_number_applied_left_trim() {
        RoundValidator.validateNumber(" 12");
    }

    @Test
    @DisplayName("숫자만 입력해야 한다. 좌, 우측에 존재하는 공백은 허용한다")
    void only_number_applied_right_trim() {
        RoundValidator.validateNumber("12 ");
    }

    @Test
    @DisplayName("연속된 수만 가능하며, 그렇지 않은 경우 예외 발생")
    void number_between_whitespace_then_exception() {
        Assertions.assertThatThrownBy(() -> RoundValidator.validateNumber(" 1 25"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("수를 입력해주세요.");
    }

    @Test
    @DisplayName("수가 아니면 예외 발생")
    void not_numeric_then_exception() {
        Assertions.assertThatThrownBy(() -> RoundValidator.validateNumber("한번"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("수를 입력해주세요.");
    }
}
