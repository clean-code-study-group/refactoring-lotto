package ui;

import lotto.FakeLottoTicket;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersPrintTextTest {

    @Test
    void testToString() {
        LottoNumbersPrintText lottoNumbersPrintText = new LottoNumbersPrintText(FakeLottoTicket.of(1, 2, 3, 4, 5, 6));

        assertThat(lottoNumbersPrintText).hasToString("[1, 2, 3, 4, 5, 6]");
    }
}
