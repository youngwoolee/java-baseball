import domain.BaseBallGame;
import domain.BaseBallNumbers;
import domain.GameType;
import view.InputView;
import view.OutputView;

import java.util.Arrays;

public class BaseBallApplication {
    private static GameType gameType;

    public static void main(String[] args) {

        while (gameType != GameType.END) {
            BaseBallGame baseBallGame = new BaseBallGame();
            gameType = baseBallGame.start();
        }

    }
}
