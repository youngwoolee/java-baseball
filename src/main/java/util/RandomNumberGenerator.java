package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {

    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    public static final int PICK_NUM = 3;

    private static List<Integer> sourceNumber;
    static {
        sourceNumber = new ArrayList<>(MAX_NUM);
        for (int i = MIN_NUM; i <= MAX_NUM; i++) {
            sourceNumber.add(i);
        }
    }

    public static List<Integer> getNumbers() {
        List<Integer> ballBasicNumbers = sourceNumber;
        Collections.shuffle(ballBasicNumbers);
        return ballBasicNumbers.subList(0, PICK_NUM);
    }
}
