package ui;

import lotto.WinningAmounts;
import lotto.WinningLottoStatistics;

import java.util.stream.IntStream;

public class WinningLottoStatisticsPrintText {
    private static final String NEXT_LINE = "\n";
    public static final int WINNING_AMOUNT_START_MATCH_COUNT = 3;
    public static final int WINNING_AMOUNT_END_MATCH_COUNT = 6;
    private final WinningLottoStatistics winningLottoStatistics;

    public WinningLottoStatisticsPrintText(WinningLottoStatistics winningLottoStatistics) {
        this.winningLottoStatistics = winningLottoStatistics;
    }

    private void appendWithNextLine(StringBuilder sb, String text) {
        sb.append(text)
                .append(NEXT_LINE);
    }

    private void appendMatchedCountText(StringBuilder sb, int matchedCount) {
        String matchedCountText = matchedCount + "개 일치 (" + WinningAmounts.get(matchedCount) + "원)- " + winningLottoStatistics.countWinningTickets(matchedCount) + "개";
        appendWithNextLine(sb, matchedCountText);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        appendWithNextLine(sb, "");
        appendWithNextLine(sb, "당첨 통계");
        appendWithNextLine(sb, "---------");

        IntStream.rangeClosed(WINNING_AMOUNT_START_MATCH_COUNT, WINNING_AMOUNT_END_MATCH_COUNT).forEach((matchedCount) -> appendMatchedCountText(sb, matchedCount));

        appendWithNextLine(sb, "총 수익률은" + winningLottoStatistics.calculateTotalWinningAmount() + "입니다.");

        return sb.toString();
    }
}
