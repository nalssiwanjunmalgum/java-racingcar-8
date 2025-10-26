package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차는 전진할 수 있다")
    void car_moves() {
        Car car = new Car(new Position());
        car.move();

        assertThat(car.getPosition()).isEqualTo(new Position(1L));
    }

    @Test
    @DisplayName("자동차가 전진하지 않으면 Position 내 값이 변하지 않는다")
    void car_position_value_not_change() {
        Car car = new Car(new Position());

        assertThat(car.getPosition()).isEqualTo(new Position(0L));
    }
}
