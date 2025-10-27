package racingcar;

import racingcar.service.RacingService;
import racingcar.util.RandomNumberProvider;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(
                new InputView(), new OutputView(),
                new RacingService(new RandomNumberProvider())
        );

        racingGame.registerConfig();
        racingGame.run();
        racingGame.printResult();
    }
}
