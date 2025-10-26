package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    @DisplayName("Position 생성하면 0이 기본값")
    void create_new_position() {
        Position position = new Position();
        Assertions.assertThat(position).isEqualTo(new Position(0L));
    }

    @Test
    @DisplayName("Position 증가하면 하나씩 증가한다")
    void increment_position_add_one() {
        Position position = new Position(5L);
        Assertions.assertThat(position.increment()).isEqualTo(new Position(6L));
    }


}
