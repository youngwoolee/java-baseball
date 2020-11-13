package domain;

import java.util.EnumMap;
import java.util.List;

public class GameResult {

    private EnumMap<BaseBallNumberResult, Integer> gameResult = new EnumMap<>(BaseBallNumberResult.class);

    private GameResult(List<BaseBallNumberResult> baseBallNumberResults) {
        for(BaseBallNumberResult baseBallNumberResult : baseBallNumberResults) {
            gameResult.put(baseBallNumberResult, gameResult.getOrDefault(baseBallNumberResult, 0) + 1);
        }
    }

    public static GameResult of(List<BaseBallNumberResult> baseBallNumberResults) {
        return new GameResult(baseBallNumberResults);
    }

    public boolean isSuccess() {
        if(gameResult.containsKey(BaseBallNumberResult.STRIKE)) {
            return gameResult.get(BaseBallNumberResult.STRIKE) == BaseBallNumbers.PICK_NUM_SIZE;
        }
        return false;
    }

    public boolean isNothing() {
        return !gameResult.containsKey(BaseBallNumberResult.STRIKE) && !gameResult.containsKey(BaseBallNumberResult.BALL);
    }

    public EnumMap<BaseBallNumberResult, Integer> getGameResult() {
        return gameResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameResult)) return false;

        GameResult that = (GameResult) o;

        return gameResult.equals(that.gameResult);
    }

    @Override
    public int hashCode() {
        return gameResult.hashCode();
    }
}
