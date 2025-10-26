package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.domain.vo.CarName;
import racingcar.domain.vo.Position;
import racingcar.domain.vo.RandomCarSignals;
import racingcar.util.CarNamesValidator;

public class RacingCarsTest {

    @Nested
    @DisplayName("자동차 이름은 쉼표를 기준으로 구분한다")
    class CarNamesValidatorTest {

        @Nested
        @DisplayName("구분자 그리고 5자 이하면 성공")
        class Success {
            @Test
            @DisplayName("단독 참여인 경우")
            void single_name() {
                Assertions.assertThatCode(() -> CarNamesValidator.validateDelimiter("pobi"))
                        .doesNotThrowAnyException();
            }

            @Test
            @DisplayName("복수 참여인 경우")
            void plural_names() {
                Assertions.assertThatCode(() -> CarNamesValidator.validateDelimiter("pobi,wooni"))
                        .doesNotThrowAnyException();
            }
        }

        @Nested
        @DisplayName("구분자가 없거나, 5자가 넘으면 실패")
        class Failure {
            @ParameterizedTest
            @NullAndEmptySource
            void null_or_empty_input_exception(String nullOrEmptySource) {
                Assertions.assertThatThrownBy(() -> CarNamesValidator.validateDelimiter(nullOrEmptySource))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("비어있는 문자열을 입력했습니다.");
            }

            @Test
            @DisplayName("쉼표가 없는 경우")
            void no_comma() {
                Assertions.assertThatThrownBy(() -> CarNamesValidator.validateDelimiter("pobi wooni"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("구분자와 공백을 확인해주세요.");
            }

            @Test
            @DisplayName("쉼표가 없는 경우")
            void comma_but_no_more_name() {
                Assertions.assertThatThrownBy(() -> CarNamesValidator.validateDelimiter("pobi,"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("구분자와 공백을 확인해주세요.");
            }

            @Test
            @DisplayName("쉼표가 아닌 다른 문자를 구분자로 사용한 경우")
            void different_delimiter() {
                Assertions.assertThatThrownBy(() -> CarNamesValidator.validateDelimiter("pobi#wooni"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("구분자와 공백을 확인해주세요.");
            }

            @Test
            @DisplayName("이름이 5자를 넘는 경우")
            void name_over_5_then_exception() {
                Assertions.assertThatThrownBy(() -> CarNamesValidator.validateDelimiter("pobi,woonin"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("구분자와 공백을 확인해주세요.");
            }
        }
    }

    @Nested
    @DisplayName("통합 테스트")
    class IntegrationTest {
        @Test
        @DisplayName("정상 동작")
        void integration() {
            Assertions.assertThatCode( () -> new RacingCars("pobi,woni") )
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("구성된 Car 요소 확인")
        void check_internal_element() {
            RacingCars racingCars = new RacingCars("pobi,woni,right");
            Assertions.assertThat(racingCars.getRacingCars())
                    .containsExactly(new Car(new CarName("pobi")),
                            new Car(new CarName("woni")),
                            new Car(new CarName("right")));
        }

        @Test
        @DisplayName("구성된 Car 요소 내 position 확인")
        void check_internal_element_position_0L() {
            RacingCars racingCars = new RacingCars("pobi,woni,right");
            List<Car> internalCars = racingCars.getRacingCars();

            for (Car car : internalCars) {
                Assertions.assertThat(car.getPosition()).isEqualTo(new Position());
            }
        }
    }

    @Nested
    @DisplayName("신호를 받아 전진 여부를 결정합니다")
    class moveOrStopWithRandomSignalTest {
        RacingCars racingCars = new RacingCars("pobi,woni,right");
        RandomCarSignals randomCarSignalSA = new RandomCarSignals(List.of(1, 3, 4));
        RandomCarSignals randomCarSignalSB = new RandomCarSignals(List.of(1, 7, 4));

        @Test
        @DisplayName("RandomCarSignals를 받아 전진 여부를 결정합니다")
        void receive_RandomCarSignals() {
            racingCars.receiveSignals(randomCarSignalSA);

            List<Car> cars = racingCars.getRacingCars();
            Car stoppedCarA = cars.get(0);
            Car stoppedCarB = cars.get(1);
            Car movedCar = cars.get(2);

            Assertions.assertThat(stoppedCarA.getPosition())
                    .isEqualTo(new Position(0L));
            Assertions.assertThat(stoppedCarA.getCarName())
                    .isEqualTo(new CarName("pobi"));

            Assertions.assertThat(stoppedCarB.getPosition())
                    .isEqualTo(new Position(0L));
            Assertions.assertThat(stoppedCarB.getCarName())
                    .isEqualTo(new CarName("woni"));

            Assertions.assertThat(movedCar.getPosition())
                    .isEqualTo(new Position(1L));
            Assertions.assertThat(movedCar.getCarName())
                    .isEqualTo(new CarName("right"));

            List<Car> winner = racingCars.findWinner();
            Assertions.assertThat(winner).containsExactly(movedCar);
        }

        @Test
        @DisplayName("RandomCarSignals를 받아 전진 여부를 결정합니다")
        void receive_RandomCarSignals_2() {
            racingCars.receiveSignals(randomCarSignalSB);

            List<Car> cars = racingCars.getRacingCars();
            Car stoppedCarA = cars.get(0);
            Car movedCarA = cars.get(1);
            Car movedCarB = cars.get(2);

            Assertions.assertThat(stoppedCarA.getPosition())
                    .isEqualTo(new Position(0L));
            Assertions.assertThat(stoppedCarA.getCarName())
                    .isEqualTo(new CarName("pobi"));

            Assertions.assertThat(movedCarA.getPosition())
                    .isEqualTo(new Position(1L));
            Assertions.assertThat(movedCarA.getCarName())
                    .isEqualTo(new CarName("woni"));

            Assertions.assertThat(movedCarB.getPosition())
                    .isEqualTo(new Position(1L));
            Assertions.assertThat(movedCarB.getCarName())
                    .isEqualTo(new CarName("right"));

            List<Car> winner = racingCars.findWinner();
            Assertions.assertThat(winner).containsExactly(movedCarA, movedCarB);
        }
    }
}
