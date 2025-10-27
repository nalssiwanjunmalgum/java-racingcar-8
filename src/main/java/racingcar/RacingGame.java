package racingcar;

import racingcar.service.RacingService;

public class RacingGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingGame(InputView inputView, OutputView outputView, RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void registerConfig() {
        String carNamesInput = inputView.getCarNamesInput();
        String roundInput = inputView.getRoundInput();
        racingService.registerInfo(roundInput, carNamesInput);
    }

    public void run() {
        outputView.printLine();
        outputView.printStatusMessage();

        while (racingService.hasMoreRound()) {
            outputView.printStatus(racingService.executePerRound());
        }
    }

    public void printResult() {
        outputView.printWinner(racingService.getWinner());
    }
}
