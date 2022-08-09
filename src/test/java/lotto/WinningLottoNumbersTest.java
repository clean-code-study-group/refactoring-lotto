package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningLottoNumbersTest {

    @Test
    void from_and_getLottoNumbers() {
        // given
        String[] rawLottoNumbers = new String[]{"1", "2", "3", "4", "5", "6"};

        // when
        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.from(rawLottoNumbers);

        // then
        assertThat(winningLottoNumbers.getLottoNumbers()).containsExactlyElementsOf(List.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        ));
    }

    @Test
    void from_over_size() {
        // given
        String[] rawLottoNumbers = new String[]{"1", "2", "3", "4", "5", "6", "7"};

        // when, then
        assertThatThrownBy(() -> WinningLottoNumbers.from(rawLottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void from_invalid_type_raw_numbers() {
        // given
        String[] rawLottoNumbers = new String[]{"a", "2", "b", "4", "5", "6", "7"};

        // when, then
        assertThatThrownBy(() -> WinningLottoNumbers.from(rawLottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void from_and_countMatches() {
        // given
        String[] rawLottoNumbers = new String[]{"1", "2", "3", "4", "5", "6"};
        FakeLottoTicket sixMatchedFakeLottoTicket = FakeLottoTicket.of(1, 2, 3, 4, 5, 6);
        FakeLottoTicket fiveMatchedFakeLottoTicket = FakeLottoTicket.of(1, 2, 3, 4, 5, 45);
        FakeLottoTicket fourMatchedFakeLottoTicket = FakeLottoTicket.of(1, 2, 3, 4, 44, 45);
        FakeLottoTicket threeMatchedFakeLottoTicket = FakeLottoTicket.of(1, 2, 3, 43, 44, 45);
        FakeLottoTicket twoMatchedFakeLottoTicket = FakeLottoTicket.of(1, 2, 42, 43, 44, 45);
        FakeLottoTicket oneMatchedFakeLottoTicket = FakeLottoTicket.of(1, 41, 42, 43, 44, 45);

        // when, then
        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.from(rawLottoNumbers);
        assertAll(
                () -> assertThat(winningLottoNumbers.countMatches(sixMatchedFakeLottoTicket)).isEqualTo(6),
                () -> assertThat(winningLottoNumbers.countMatches(fiveMatchedFakeLottoTicket)).isEqualTo(5),
                () -> assertThat(winningLottoNumbers.countMatches(fourMatchedFakeLottoTicket)).isEqualTo(4),
                () -> assertThat(winningLottoNumbers.countMatches(threeMatchedFakeLottoTicket)).isEqualTo(3),
                () -> assertThat(winningLottoNumbers.countMatches(twoMatchedFakeLottoTicket)).isEqualTo(2),
                () -> assertThat(winningLottoNumbers.countMatches(oneMatchedFakeLottoTicket)).isEqualTo(1)
        );
    }
}

