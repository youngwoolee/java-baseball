package domain;

import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class BaseBallGame {

    private BaseBallNumbers answer;
    private boolean finished;

    public BaseBallGame() {}

    public void play(BaseBallNumbers guessBaseBallNumbers) {
        GameResult gameResult = match(guessBaseBallNumbers);
        OutputView.printResult(gameResult);
        if(gameResult.isSuccess()) {
            this.finished = true;
        }
    }

    public GameResult match(BaseBallNumbers guessNumbers) {
        return answer.compareBaseBallNumbers(guessNumbers);
    }

    public GameType start() {
        this.answer = BaseBallNumbers.of(RandomNumberGenerator.getNumbers());
        while(true) {
            BaseBallNumbers guessBaseBallNumbers = InputView.inputGuessNumbers();
            play(guessBaseBallNumbers);
            if(finished) {
                OutputView.printSuccess();
            }
        }
    }
}
