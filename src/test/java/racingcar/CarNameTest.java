package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    @DisplayName("이름은 5자 이하만 가능합니다")
    void under_5_letters_constructor() {
        Assertions.assertThatCode(
                () -> new CarName("sunli")
        ).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("(공백을 포함한) 이름은 5자 이하면 예외가 발생하지 않습니다")
    void less_5_letters_including_whitespace() {
        Assertions.assertThatCode(
                () -> new CarName("   su")
        ).doesNotThrowAnyException();

    }

    @Test
    @DisplayName("이름은 5자가 넘어가면 예외가 발생합니다")
    void over_5_letters_exception() {
        Assertions.assertThatThrownBy(
                () -> new CarName("sungling")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("(공백을 포함한) 이름은 5자가 넘어가면 예외가 발생합니다")
    void over_5_letters_including_whitespace_exception() {
        Assertions.assertThatThrownBy(
                () -> new CarName("   sui")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
