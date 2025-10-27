package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_FORMAT = "%s\n";
    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String getInput() {
        return Console.readLine();
    }

    public String getCarNamesInput() {
        System.out.printf(INPUT_FORMAT, CAR_NAMES_MESSAGE);
        return getInput();
    }

    public String getRoundInput() {
        System.out.printf(INPUT_FORMAT, ROUND_MESSAGE);
        return getInput();
    }
}
