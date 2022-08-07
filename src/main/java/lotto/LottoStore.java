package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private LottoStore() {
    }

    public static final int LOTTO_TICKET_PRICE = 1000;

    public static List<LottoTicket> buy(Integer totalPurchasedAmount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < calculateTicketCount(totalPurchasedAmount); i++) {
            LottoTicket lottoTicket = LottoTicket.create();

            lottoTickets.add(lottoTicket);
        }

        return lottoTickets;
    }

    private static int calculateTicketCount(Integer totalPurchasedAmount) {
        return totalPurchasedAmount / LOTTO_TICKET_PRICE;
    }
}
