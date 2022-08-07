package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningAmountsTest {

    @Test
    void 로또번호일치갯수에따른_당첨금액() {
        assertAll(
                () -> assertThat(WinningAmounts.get(3)).isEqualTo(5000L),
                () -> assertThat(WinningAmounts.get(4)).isEqualTo(50000L),
                () -> assertThat(WinningAmounts.get(5)).isEqualTo(1500000L),
                () -> assertThat(WinningAmounts.get(6)).isEqualTo(2000000000L)
        );
    }

    @Test
    void 지정되지않은_일치갯수는_당첨금액이_없다() {
        assertAll(
                () -> assertThat(WinningAmounts.get(0)).isEqualTo(0),
                () -> assertThat(WinningAmounts.get(1)).isEqualTo(0),
                () -> assertThat(WinningAmounts.get(2)).isEqualTo(0),
                () -> assertThat(WinningAmounts.get(999)).isEqualTo(0),
                () -> assertThat(WinningAmounts.get(-1)).isEqualTo(0)
        );
    }
}
