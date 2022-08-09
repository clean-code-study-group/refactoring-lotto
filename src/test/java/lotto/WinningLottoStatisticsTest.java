package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningLottoStatisticsTest {

    @Test
    void create() {
        // given, when, then
        WinningLottoStatistics winningLottoStatistics = WinningLottoStatisticsFixture.createFixture();

        assertAll(
                () -> assertThat(winningLottoStatistics.countWinningTickets(6)).isEqualTo(2),
                () -> assertThat(winningLottoStatistics.countWinningTickets(5)).isEqualTo(3),
                () -> assertThat(winningLottoStatistics.countWinningTickets(4)).isEqualTo(1),
                () -> assertThat(winningLottoStatistics.countWinningTickets(3)).isEqualTo(1),
                () -> assertThat(winningLottoStatistics.countWinningTickets(2)).isEqualTo(2),
                () -> assertThat(winningLottoStatistics.countWinningTickets(1)).isEqualTo(1)
        );
    }

    @Test
    void calculateTotalWinningAmount() {
        // given, when, then
        WinningLottoStatistics winningLottoStatistics = WinningLottoStatisticsFixture.createFixture();

        assertThat(winningLottoStatistics.calculateProfitRate()).isEqualTo(
            2.4971563631914157E-6
        );
    }
}
