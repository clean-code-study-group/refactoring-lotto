package lotto;

import java.util.List;

public class WinningLottoStatisticsFixture {
    public static WinningLottoStatistics createFixture() {
        List<LottoNumbers> fakeLottoTickets = List.of(
                FakeLottoTicket.of(1, 2, 3, 4, 5, 6),
                FakeLottoTicket.of(1, 2, 3, 4, 5, 6), // 6개 일치 2개

                FakeLottoTicket.of(1, 2, 3, 4, 5, 45),
                FakeLottoTicket.of(1, 2, 3, 4, 5, 45),
                FakeLottoTicket.of(1, 2, 3, 4, 5, 45), // 5개 일치 3개

                FakeLottoTicket.of(1, 2, 3, 4, 44, 45), // 4개 일치 1개

                FakeLottoTicket.of(1, 2, 3, 43, 44, 45), // 3개 일치 1개

                FakeLottoTicket.of(1, 2, 42, 43, 44, 45),
                FakeLottoTicket.of(1, 2, 42, 43, 44, 45), // 2개 일치 2개

                FakeLottoTicket.of(1, 41, 42, 43, 44, 45) // 1개 일치 1개
        );

        String[] rawLottoNumbers = new String[]{"1", "2", "3", "4", "5", "6"};

        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.from(rawLottoNumbers);

        return new WinningLottoStatistics(fakeLottoTickets, winningLottoNumbers);
    }
}
