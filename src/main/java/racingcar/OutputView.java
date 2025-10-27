package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.domain.vo.CarName;
import racingcar.domain.vo.Position;

public class OutputView {
    private static final String STATUS_FIRST_LINE = "실행 결과";
    private static final String STATUS_FORMAT = "%s : %s\n";
    private static final String DISPLAY_SYMBOL = "-";
    private static final String TOTAL_WINNER_MESSAGE = "최종 우승자";
    private static final String WINNER_DELIMITER = ", ";

    public void printStatus(RacingCars racingCars) {
        List<Car> racingStatus = racingCars.getRacingCars();
        for (Car carStatus : racingStatus) {
            printEachStatus(carStatus);
        }

        printLine();
    }

    public void printLine() {
        System.out.println();
    }

    public void printStatusMessage() {
        System.out.println(STATUS_FIRST_LINE);
    }

    public void printWinner(List<Car> winner) {
        List<String> winners = new ArrayList<>();
        for (Car car : winner) {
            winners.add(car.getCarNameValue());
        }

        String finalWinners = String.join(WINNER_DELIMITER , winners);
        System.out.printf(STATUS_FORMAT, TOTAL_WINNER_MESSAGE, finalWinners);
    }

    private void printEachStatus(Car carStatus) {
        Position position = carStatus.getPosition();
        CarName carName = carStatus.getCarName();

        System.out.printf(STATUS_FORMAT, carName, convertToDisplay(position));
    }

    private String convertToDisplay(Position position) {
        StringBuilder stringBuilder = new StringBuilder();
        long positionValue = position.getPositionValue();

        for (int i = 0; i < positionValue; i++) {
            stringBuilder.append(DISPLAY_SYMBOL);
        }
        return stringBuilder.toString();
    }
}
