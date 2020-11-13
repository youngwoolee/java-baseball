import controller.BaseBallGame;
import domain.GameType;
import util.NumberGenerator;
import util.RandomNumberGenerator;

public class BaseBallApplication {
    private static GameType gameType;

    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        while (gameType != GameType.END) {
            BaseBallGame baseBallGame = new BaseBallGame(generator);
            gameType = baseBallGame.start();
        }
    }
}
