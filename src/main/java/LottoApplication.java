import lotto.LottoStore;
import lotto.LottoTicket;
import lotto.WinningLottoNumbers;
import ui.LottoController;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int totalPurchasedAmount = LottoController.enterTotalPurchasedAmount();
        List<LottoTicket> boughtLottoTickets = LottoStore.buy(totalPurchasedAmount);
        LottoController.printBoughtLottoTickets(boughtLottoTickets);

        WinningLottoNumbers winningLottoNumbers = LottoController.enterWinningLottoNumbers();

        LottoController.printWinningLottoNumbers(winningLottoNumbers);
        LottoController.printWinningLottoStatistics(boughtLottoTickets, winningLottoNumbers);
    }
}
