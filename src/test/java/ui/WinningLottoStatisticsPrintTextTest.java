package ui;

import lotto.WinningLottoStatistics;
import lotto.WinningLottoStatisticsFixture;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinningLottoStatisticsPrintTextTest {

    @Test
    void testToString() {
        // given
        WinningLottoStatistics winningLottoStatistics = WinningLottoStatisticsFixture.createFixture();
        WinningLottoStatisticsPrintText winningLottoStatisticsPrintText = new WinningLottoStatisticsPrintText(winningLottoStatistics);

        // when, then
        assertThat(winningLottoStatisticsPrintText).hasToString("\n" +
                "당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- 1개\n" +
                "4개 일치 (50000원)- 1개\n" +
                "5개 일치 (1500000원)- 3개\n" +
                "6개 일치 (2000000000원)- 2개\n" +
                "총 수익률은2.4971563631914157E-6입니다.\n");
    }
}
