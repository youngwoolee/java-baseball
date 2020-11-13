package domain;

import java.util.*;

public class BaseBallNumbers {

    public static final int PICK_NUM_SIZE = 3;
    private List<BaseBallNumber> baseBallNumbers;


    private BaseBallNumbers(final List<BaseBallNumber> baseBallNumbers) {
        this.baseBallNumbers = baseBallNumbers;
    }

    public static BaseBallNumbers of(final List<Integer> numbers) {
        validation(numbers);
        return new BaseBallNumbers(convertBaseBallNumber(numbers));
    }

    private static void validation(final List<Integer> numbers) {
        if(numbers == null || numbers.size() != PICK_NUM_SIZE) {
            throw new IllegalArgumentException("정확히 3개 숫자만 선택 할수 있습니다.");
        }
        duplicationCheck(numbers);
    }

    private static void duplicationCheck(final List<Integer> numbers) {
        Set<Integer> notDuplicated = new HashSet<>(numbers);
        if(notDuplicated.size() < PICK_NUM_SIZE) {
            throw new IllegalArgumentException("중복된 숫자는 들어갈수 없습니다");
        }
    }

    private static List<BaseBallNumber> convertBaseBallNumber(final List<Integer> numbers) {
        List<BaseBallNumber> baseBallNumbers = new ArrayList<>();
        for(int i=0; i<numbers.size(); i++) {
            baseBallNumbers.add(BaseBallNumber.of(i, numbers.get(i)));
        }
        return baseBallNumbers;
    }

    public List<BaseBallNumber> getBaseBallNumbers() {
        return baseBallNumbers;
    }


    public GameResult compareBaseBallNumbers(BaseBallNumbers guessBaseBallNumbers) {
        List<BaseBallNumberResult> baseBallNumberResults = new ArrayList<>();
        for (BaseBallNumber baseBallNumber : guessBaseBallNumbers.getBaseBallNumbers()) {
            baseBallNumberResults.add(baseBallNumber.compareBaseBallNumber(baseBallNumbers));
        }
        return GameResult.of(baseBallNumberResults);
    }
}
