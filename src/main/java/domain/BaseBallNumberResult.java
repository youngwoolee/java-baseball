package domain;

public enum BaseBallNumberResult {
    STRIKE("스트라이크"),
    BALL("볼"),
    OUT("아웃");

    public String text;

    BaseBallNumberResult(String text) {
        this.text = text;
    }
}
