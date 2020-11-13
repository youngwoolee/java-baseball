package domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum GameType {
    RETRY(1),
    END(2);

    public int value;

    GameType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private static Map<Integer, GameType> CATEGORY_MAP = Arrays.stream(GameType.values())
            .collect(Collectors.toMap(GameType::getValue, c -> c));


    public static GameType getGameType(Integer keyName) {
        GameType gameType =  CATEGORY_MAP.get(keyName);
        if(gameType == null) {
            throw new IllegalArgumentException("keyName [" + keyName + "] not supported.");
        }

        return gameType;
    }

    public boolean isEnd() {
        return this.equals(GameType.END);
    }
}
