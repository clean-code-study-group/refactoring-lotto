package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningAmounts {
    private static final Map<Integer, Long> WINNING_AMOUNTS_BY_MATCHED_COUNT = new HashMap<>();
    private static final long NONE_AMOUNT = 0L;

    static {
        WINNING_AMOUNTS_BY_MATCHED_COUNT.put(3, 5000L);
        WINNING_AMOUNTS_BY_MATCHED_COUNT.put(4, 50000L);
        WINNING_AMOUNTS_BY_MATCHED_COUNT.put(5, 1500000L);
        WINNING_AMOUNTS_BY_MATCHED_COUNT.put(6, 2000000000L);
    }

    public static Long get(int matchedCount) {
        return WINNING_AMOUNTS_BY_MATCHED_COUNT.getOrDefault(matchedCount, NONE_AMOUNT);
    }
}
