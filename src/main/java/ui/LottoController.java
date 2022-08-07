package ui;

import lotto.LottoTicket;
import lotto.WinningLottoNumbers;
import lotto.WinningLottoStatistics;

import java.util.List;
import java.util.Scanner;

public class LottoController {
    private LottoController() {}

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int enterTotalPurchasedAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int totalPurchasedAmount = Integer.parseInt(SCANNER.nextLine());

        return totalPurchasedAmount;
    }

    public static void printBoughtLottoTickets(List<LottoTicket> boughtLottoTickets) {
        boughtLottoTickets.stream()
                .map(LottoNumbersPrintText::new)
                .forEach(System.out::println);
        System.out.println(boughtLottoTickets.size() + "개를 구매했습니다.");
    }

    public static WinningLottoNumbers enterWinningLottoNumbers() {
        printBreakLine();
        System.out.println("당첨 번호를 입력해 주세요.");
        String rawWinningLottoNumbers = SCANNER.nextLine();
        return WinningLottoNumbers.from(rawWinningLottoNumbers.split(", "));
    }

    public static void printWinningLottoNumbers(WinningLottoNumbers winningLottoNumbers) {
        System.out.println(new LottoNumbersPrintText(winningLottoNumbers));
    }

    public static void printWinningLottoStatistics(List<LottoTicket> boughtLottoTickets, WinningLottoNumbers winningLottoNumbers) {
        WinningLottoStatistics winningLottoStatistics = new WinningLottoStatistics(boughtLottoTickets, winningLottoNumbers);

        WinningLottoStatisticsPrintText winningLottoStatisticsPrintText = new WinningLottoStatisticsPrintText(winningLottoStatistics);

        System.out.println(winningLottoStatisticsPrintText);
    }

    private static void printBreakLine() {
        System.out.println();
    }
}
