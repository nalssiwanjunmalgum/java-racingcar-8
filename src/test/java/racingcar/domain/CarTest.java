package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.vo.CarName;
import racingcar.domain.vo.CarSignal;
import racingcar.domain.vo.Position;

public class CarTest {
    private final CarName carName = new CarName("sung");
    private final Position initPosition = new Position();

    @Test
    @DisplayName("자동차는 전진할 수 있다. 이름은 변하지 않는다.")
    void car_moves() {
        Car car = new Car(initPosition, carName);
        car.move();

        assertThat(car.getPosition()).isEqualTo(new Position(1L));
        assertThat(car.getCarName()).isEqualTo(new CarName("sung"));
    }

    @Test
    @DisplayName("자동차가 전진하지 않으면 Position 내 값이 변하지 않는다")
    void car_position_value_not_change() {
        Car car = new Car(initPosition, carName);

        assertThat(car.getPosition()).isEqualTo(new Position(0L));
        assertThat(car.getCarName()).isEqualTo(new CarName("sung"));
    }

    @Nested
    @DisplayName("외부에서 CarSignal을 전달받는다")
    class CarSignalTest {
        private final Car initCar = new Car(initPosition, carName);

        @Test
        @DisplayName("4이상이면 전진한다.")
        void over_or_same_4_move() {
            initCar.receiveCarSignal(new CarSignal(4));
            Assertions.assertThat(initCar.getPosition())
                    .isEqualTo(new Position(1L));
        }

        @Test
        @DisplayName("4미만이면 전진하지 않는다.")
        void less_4_move() {
            initCar.receiveCarSignal(new CarSignal(3));
            Assertions.assertThat(initCar.getPosition())
                    .isEqualTo(new Position(0L));
        }
    }
}
