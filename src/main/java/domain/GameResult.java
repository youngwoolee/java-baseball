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
