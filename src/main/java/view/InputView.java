package view;

import domain.BaseBallNumbers;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static BaseBallNumbers inputGuessNumbers() {
        List<Integer> inputNumbers = new ArrayList<Integer>();
        System.out.println("1~9까지의 3자리 숫자를 입력하세요");
        String[] split = SCANNER.nextLine().split("");
        for(String s : split) inputNumbers.add(Integer.valueOf(s));
        return BaseBallNumbers.of(inputNumbers);
    }
}
