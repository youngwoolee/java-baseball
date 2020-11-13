package domain;

public class BaseBallNumber {

    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;

    private int index;
    private int number;

    private BaseBallNumber(int index, int number) {
        validation(number);
        this.index = index;
        this.number = number;
    }

    public static BaseBallNumber of(final int index, final int number) {
        return new BaseBallNumber(index, number);
    }

    private void validation(final int number) {
        if(number < MIN_NUM || number > MAX_NUM){
            throw new IllegalArgumentException("1~9 사이의 숫자만 가능합니다");
        }
    }

    public int getIndex() {
        return index;
    }

    public int getNumber() {
        return number;
    }
}
