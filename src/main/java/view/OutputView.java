package view;

import domain.BaseBallNumberResult;
import domain.GameResult;

public class OutputView {
    private static final String STRIKE_FORMAT = "%d 스트라이크";
    private static final String BALL_FORMAT = "%d 볼";
    private static final String NOTHING_FORMAT = "낫싱";
    private static final String SUCCESS_FORMAT = "3개의 숫자를 모두 맞히셨습니다! 게임종료";

    public static void printResult(final GameResult gameResult) {
        if(gameResult.isNothing()) {
            System.out.println(NOTHING_FORMAT);
            return;
        }
        gameResult.getGameResult()
                .keySet()
                .forEach(baseBallNumberResult -> print(gameResult, baseBallNumberResult));
    }

    private static void print(GameResult gameResult, BaseBallNumberResult baseBallNumberResult) {
        if(baseBallNumberResult == BaseBallNumberResult.STRIKE) {
            System.out.println(String.format(STRIKE_FORMAT, gameResult.getGameResult().get(baseBallNumberResult)));
        }
        if(baseBallNumberResult == BaseBallNumberResult.BALL) {
            System.out.println(String.format(BALL_FORMAT, gameResult.getGameResult().get(baseBallNumberResult)));
        }
    }

    public static void printSuccess() {
        System.out.println(SUCCESS_FORMAT);
    }
}
