package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private final CarName carName = new CarName("sung");

    @Test
    @DisplayName("자동차는 전진할 수 있다. 이름은 변하지 않는다.")
    void car_moves() {
        Car car = new Car(new Position(), carName);
        car.move();

        assertThat(car.getPosition()).isEqualTo(new Position(1L));
        assertThat(car.getCarName()).isEqualTo(new CarName("sung"));
    }

    @Test
    @DisplayName("자동차가 전진하지 않으면 Position 내 값이 변하지 않는다")
    void car_position_value_not_change() {
        Car car = new Car(new Position(), carName);

        assertThat(car.getPosition()).isEqualTo(new Position(0L));
        assertThat(car.getCarName()).isEqualTo(new CarName("sung"));
    }
}
