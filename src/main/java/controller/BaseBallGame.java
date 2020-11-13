package controller;

import domain.BaseBallNumbers;
import domain.GameResult;
import domain.GameType;
import util.NumberGenerator;
import view.InputView;
import view.OutputView;

public class BaseBallGame {

    private BaseBallNumbers answer;
    private GameResult gameResult;
    private NumberGenerator generator;

    public BaseBallGame(NumberGenerator generator) {
        this.generator = generator;
    }

    public void play(BaseBallNumbers guessBaseBallNumbers) {
        match(guessBaseBallNumbers);
        OutputView.printResult(this.gameResult);
    }

    public void match(BaseBallNumbers guessNumbers) {
        this.gameResult = this.answer.compareBaseBallNumbers(guessNumbers);
    }

    public GameType start() {
        this.answer = BaseBallNumbers.of(this.generator.getNumbers());
        while(true) {
            BaseBallNumbers guessBaseBallNumbers = InputView.inputGuessNumbers();
            play(guessBaseBallNumbers);
            if(this.gameResult.isSuccess()) {
                OutputView.printSuccess();
                return InputView.replayCheck();
            }
        }
    }
}