import lotto.LottoStore;
import lotto.LottoTicket;

import java.util.*;

public class LottoApplication {
    static final int LOTTO_TICKET_CONSISTENCY_SIZE = 6;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int totalPurchasedAmount = Integer.parseInt(scanner.nextLine());
        LottoStore lottoStore = new LottoStore();
        List<LottoTicket> boughtLottoTickets = lottoStore.buy(totalPurchasedAmount);

        // 생성된 로또티켓들의 번호를 찍습니다.
        boughtLottoTickets.stream().map(LottoTicket::getLottoNumbers).forEach(System.out::println);
        System.out.println(boughtLottoTickets.size() + "개를 구매했습니다.");

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String rawWinningLottoNumbers = scanner.nextLine();
        LottoTicket winningLottoTicket = new LottoTicket(rawWinningLottoNumbers.split(", "));

        System.out.println(winningLottoTicket.getLottoNumbers());

        /* 당첨번호랑 구매한 티켓의 로또 번호가 숫자가 몇개가 일치하는지 체크 */
        int threeMatchCount = 0;
        int fourMatchCount = 0;
        int fiveMatchCount = 0;
        int sixMatchCount = 0;

        for (LottoTicket lottoTicket : boughtLottoTickets) {
            List<Integer> lottoNumbers = lottoTicket.getLottoNumbers();

            int count = 0;

            for (int j = 0; j < 6; j++) {
                int lottoNumber = lottoNumbers.get(j);

                for (int k = 0; k < 6; k++) {
                    int winningLottoNumber = winningLottoTicket.getLottoNumbers().get(k);

                    if (lottoNumber == winningLottoNumber) {
                        count++;
                        break;
                    }
                }
            }

            if (count == 3) {
                threeMatchCount++;
            } else if (count == 4) {
                fourMatchCount++;
            } else if (count == 5) {
                fiveMatchCount++;
            } else if (count == 6) {
                sixMatchCount++;
            }
        }


        int threeMatchWp = 5000;
        int fourMatchWp = 50000;
        int fiveMatchWp = 1500000;
        int sixMatchWp = 2000000000;

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + threeMatchWp + "원)- " + threeMatchCount + "개");
        System.out.println("4개 일치 (" + fourMatchWp + "원)- " + fourMatchCount + "개");
        System.out.println("5개 일치 (" + fiveMatchWp + "원)- " + fiveMatchCount + "개");
        System.out.println("6개 일치 (" + sixMatchWp + "원)- " + sixMatchCount + "개");

        long tWp = (long) threeMatchWp * threeMatchCount;
        tWp += (long) fourMatchWp * fourMatchCount;
        tWp += (long) fiveMatchWp * fiveMatchCount;
        tWp += (long) sixMatchWp * sixMatchCount;

        System.out.println("총 수익률은" + (tWp / totalPurchasedAmount) + "입니다.");
    }


}
