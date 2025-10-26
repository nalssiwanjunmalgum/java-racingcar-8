package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.CarNamesValidator;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(String carNamesInput) {
        validateNames(carNamesInput);
        this.racingCars = new ArrayList<>();
    }

    private void validateNames(String carNamesInput) {
        checkDelimiter(carNamesInput);
    }

    private void checkDelimiter(String carNamesInput) {
        // 문자들+(,(문자))* 형태가 되어야 함
        CarNamesValidator.validateDelimiter(carNamesInput);
    }
}
