package util;

import domain.BaseBallNumber;
import domain.BaseBallNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static List<Integer> sourceNumber;
    static {
        sourceNumber = new ArrayList<>(BaseBallNumber.MAX_NUM);
        for (int i = BaseBallNumber.MIN_NUM; i <= BaseBallNumber.MAX_NUM; i++) {
            sourceNumber.add(i);
        }
    }

    @Override
    public List<Integer> getNumbers() {
        List<Integer> ballBasicNumbers = sourceNumber;
        Collections.shuffle(ballBasicNumbers);
        return ballBasicNumbers.subList(0, BaseBallNumbers.PICK_NUM_SIZE);
    }
}
