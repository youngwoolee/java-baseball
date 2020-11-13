package domain;

import exception.ErrorMessage;

import java.util.List;

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
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_NUMBER);
        }
    }

    public boolean isStrike(final List<BaseBallNumber> baseBallNumbers) {
        return baseBallNumbers.get(this.index).getNumber() == this.number;
    }

    public boolean isBall(final List<BaseBallNumber> baseBallNumbers) {
        for(BaseBallNumber baseBallNumber : baseBallNumbers) {
            if(isBall(baseBallNumber)) {
                return true;
            }
        }
        return false;
    }

    private boolean isBall(final BaseBallNumber baseBallNumber) {
        if(this.index != baseBallNumber.index && this.number == baseBallNumber.number) {
            return true;
        }
        return false;
    }

    public int getIndex() {
        return this.index;
    }

    public int getNumber() {
        return this.number;
    }

    public BaseBallNumberResult compareBaseBallNumber(List<BaseBallNumber> baseBallNumbers) {
        if(isStrike(baseBallNumbers)){
            return BaseBallNumberResult.STRIKE;
        }
        if(isBall(baseBallNumbers)) {
            return BaseBallNumberResult.BALL;
        }
        return BaseBallNumberResult.OUT;
    }
}
