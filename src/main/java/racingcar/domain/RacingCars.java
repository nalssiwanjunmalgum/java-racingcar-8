package racingcar.domain;

import static racingcar.domain.ErrorMessage.UNMATCHED_CARS_WITH_SIGNALS;
import static racingcar.util.CarNamesValidator.COMMA_DELIMITER;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.vo.CarName;
import racingcar.domain.vo.CarSignal;
import racingcar.domain.vo.RandomCarSignals;
import racingcar.util.CarNamesValidator;

public class RacingCars {
    private final List<Car> racingCars;


    public RacingCars(String carNamesInput) {
        validateNames(carNamesInput);
        this.racingCars = new ArrayList<>();
        initNames(carNamesInput);
    }

    public List<Car> getRacingCars() {
        return List.copyOf(racingCars);
    }

    public int getSize() {
        return racingCars.size();
    }

    public void receiveSignals(RandomCarSignals randomCarSignals) {
        hasSameLength(racingCars, randomCarSignals);
        receivePerSignal(randomCarSignals);
    }

    public List<Car> findWinner() {
        long maxPositionValue = racingCars.stream()
                .mapToLong(car -> car.getPosition().getPositionValue())
                .max()
                .orElse(0L);

        return racingCars.stream()
                .filter(car -> car.getPosition().getPositionValue() == maxPositionValue)
                .toList();
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
            throw new IllegalArgumentException(UNMATCHED_CARS_WITH_SIGNALS.getMessage());
        }
    }

    private void receivePerSignal(RandomCarSignals randomCarSignals) {
        for (int idx = 0; idx < racingCars.size(); idx++) {
            Car car = racingCars.get(idx);
            CarSignal carSignal = randomCarSignals.getSignalAtIndex(idx);
            car.receiveCarSignal(carSignal);
        }
    }
}
