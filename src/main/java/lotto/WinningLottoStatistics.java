package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLottoStatistics {
    private static final int INITIALIZE_WINNING_TICKET_COUNT = 0;

    private final Map<Integer, Integer> matchCounts = new HashMap<>();

    public WinningLottoStatistics(List<? extends LottoNumbers> lottoTickets, WinningLottoNumbers winningLottoNumbers) {
        for (LottoNumbers lottoNumbers : lottoTickets) {
            int matchedCount = winningLottoNumbers.countMatches(lottoNumbers);

            increaseMatchCount(matchedCount);
        }
    }

    private void increaseMatchCount(int matchedCount) {
        int winningTicketCount = countWinningTickets(matchedCount);

        matchCounts.put(matchedCount, ++winningTicketCount);
    }

    public int countWinningTickets(int matchedCount) {
        return matchCounts.getOrDefault(matchedCount, INITIALIZE_WINNING_TICKET_COUNT);
    }

    public long calculateTotalWinningAmount() {
        long totalWinningAmount = 0L;

        for (Map.Entry<Integer, Integer> entry : matchCounts.entrySet()) {
            int matchedCount = entry.getKey();
            int winningTicketCount = entry.getValue();

            totalWinningAmount += WinningAmounts.get(matchedCount) * winningTicketCount;
        }

        return totalWinningAmount;
    }
}
