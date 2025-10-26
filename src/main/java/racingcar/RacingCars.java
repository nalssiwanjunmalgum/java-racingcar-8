package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.CarNamesValidator;

public class RacingCars {
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
