package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTicketTest {

    @Test
    void create() {
        assertDoesNotThrow(() -> {
            LottoTicket.create();
        });
    }

    @Test
    void create_and_not_allowed_update() {
        LottoTicket lottoTicket = LottoTicket.create();

        List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();
        lottoNumbers.add(LottoNumber.of(1));

        assertThat(lottoNumbers).hasSize(7);
        assertThat(lottoTicket.getLottoNumbers()).hasSize(6);
    }
}
