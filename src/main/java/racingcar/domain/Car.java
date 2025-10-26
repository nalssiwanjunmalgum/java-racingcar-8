package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.domain.vo.CarName;
import racingcar.domain.vo.CarSignal;
import racingcar.domain.vo.Position;
import racingcar.domain.vo.RandomCarSignals;
import racingcar.util.CarNamesValidator;

public class Car {
    private Position position;
    private final CarName carName;

    public Car(Position position, CarName carName) {
        this.position = position;
        this.carName = carName;
    }

    public Car(CarName carName) {
        this.position = new Position(0L);
        this.carName = carName;
    }

    public void receiveCarSignal(CarSignal carSignal) {
        if (carSignal.isPermitted()) {
            move();
        }
    }

    public void move() {
        this.position = position.increment();
    }

    public Position getPosition() {
        return new Position(position.getPositionValue());
    }

    public CarName getCarName() {
        return new CarName(carName.getNameValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                      // 동일 객체일 경우 true
        if (o == null || getClass() != o.getClass()) return false; // 타입 다르면 false
        Car car = (Car) o;
        return Objects.equals(position, car.position)
                && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, carName);
    }

    public static class RacingCars {
        private final List<Car> racingCars;
        private static final String COMMA_DELIMITER = ",";

        public RacingCars(String carNamesInput) {
            validateNames(carNamesInput);
            this.racingCars = new ArrayList<>();
            initNames(carNamesInput);
        }

        public void receiveRandomCarSignals(RandomCarSignals randomCarSignals) {
            receiveSignals(randomCarSignals);
        }

        public void receiveSignals(RandomCarSignals randomCarSignals) {
            hasSameLength(racingCars, randomCarSignals);
            receivePerSignal(randomCarSignals);
        }

        private void validateNames(String carNamesInput) {
            checkDelimiter(carNamesInput);
        }

        private void checkDelimiter(String carNamesInput) {
            CarNamesValidator.validateDelimiter(carNamesInput);
        }

        private void initNames(String carNamesInput) {
            String[] names = carNamesInput.split(COMMA_DELIMITER);
            for(String name : names) {
                Car createdCar = new Car(new CarName(name));
                racingCars.add(createdCar);
            }
        }

        private void hasSameLength(List<Car> racingCars, RandomCarSignals randomCarSignals) {
            List<CarSignal> carSignals = randomCarSignals.getCarSignals();
            if (racingCars.size() != carSignals.size()) {
                throw new IllegalArgumentException("자동차 개수와 신호의 수가 서로 다릅니다.");
            }
        }

        private void receivePerSignal(RandomCarSignals randomCarSignals) {
            for (int idx = 0; idx < racingCars.size(); idx++) {
                Car car = racingCars.get(idx);
                CarSignal carSignal = randomCarSignals.getSignalAtIndex(idx);
                car.receiveCarSignal(carSignal);
            }
        }

        public List<Car> getRacingCars() {
            return List.copyOf(racingCars);
        }
    }
}
