package view;

import domain.BaseBallNumbers;
import domain.GameType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_GUESS_NUMBER_FORMAT = "1~9까지의 3자리 숫자를 입력하세요";
    private static final String RETRY_FORMAT = "게임을새로시작하려면1,종료하려면2를입력하세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static BaseBallNumbers inputGuessNumbers() {
        List<Integer> inputNumbers = new ArrayList<Integer>();
        System.out.println(INPUT_GUESS_NUMBER_FORMAT);
        String[] split = SCANNER.nextLine().split("");
        for(String s : split) inputNumbers.add(Integer.valueOf(s));
        return BaseBallNumbers.of(inputNumbers);
    }

    public static GameType replayCheck() {
        System.out.println(RETRY_FORMAT);
        int gameType = Integer.valueOf(SCANNER.nextLine());
        return GameType.getGameType(gameType);
    }


}
