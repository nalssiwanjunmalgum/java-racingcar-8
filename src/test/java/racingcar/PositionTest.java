package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.vo.Position;

public class PositionTest {

    @Test
    @DisplayName("Position 생성하면 0이 기본값")
    void create_new_position() {
        Position position = new Position();
        Assertions.assertThat(position).isEqualTo(new Position(0L));
    }

    @Test
    @DisplayName("Position은 음수의 값을 보관할 수 없다")
    void positionValue_should_positive() {
        Assertions.assertThatThrownBy(() -> new Position(-1L))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Position 증가하면 하나씩 증가한다")
    void increment_position_add_one() {
        Position position = new Position(5L);
        Assertions.assertThat(position.increment()).isEqualTo(new Position(6L));
    }




}
