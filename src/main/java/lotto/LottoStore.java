package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public List<LottoTicket> buy(Integer totalPurchasedAmount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        /* 로또 구매 개수만큼 반복 */
        for (int i = 0; i < calculateTicketCount(totalPurchasedAmount); i++) {
            LottoTicket lottoTicket = new LottoTicket();

            lottoTickets.add(lottoTicket);
        }

        return lottoTickets;
    }

    private int calculateTicketCount(Integer totalPurchasedAmount) {
        return totalPurchasedAmount / LOTTO_TICKET_PRICE;
    }
}
