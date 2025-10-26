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

    public List<Car> getRacingCars() {
        return List.copyOf(racingCars);
    }
}
