package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @ParameterizedTest
    @CsvSource({
            "1000, 1",
            "10000, 10",
            "14000, 14",
            "20000, 20",
    })
    void buy_구입금액만큼_로또티켓갯수가구매된다(int totalPurcahsedAmount, int expectedLottoTicketSize) {
        List<LottoTicket> lottoTickets = LottoStore.buy(totalPurcahsedAmount);

        assertThat(lottoTickets).hasSize(expectedLottoTicketSize);
    }
}
