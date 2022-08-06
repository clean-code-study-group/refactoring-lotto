import lotto.LottoTicket;

import java.util.*;

public class LottoApplication {
    private static final int LOTTO_TICKET_PRICE = 1000;
    static final int LOTTO_TICKET_CONSISTENCY_SIZE = 6;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int totalAmount = Integer.parseInt(scanner.nextLine());
        System.out.println((totalAmount / LOTTO_TICKET_PRICE) + "개를 구매했습니다.");

        String[][] lottoTotalTicketNumbers = new String[totalAmount / LOTTO_TICKET_PRICE][LOTTO_TICKET_CONSISTENCY_SIZE];
        int lottoTicketSize = 0;

        /* 로또 구매 개수만큼 반복 */
        for (int i = 0; i < totalAmount / LOTTO_TICKET_PRICE; i++) {

            LottoTicket lottoTicket = new LottoTicket();
            String[] lottoNumbers = lottoTicket.generateLottoNumbers();

            System.out.println(Arrays.toString(lottoNumbers));

            lottoTotalTicketNumbers[lottoTicketSize] = lottoNumbers;
            lottoTicketSize++;
        }

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String rwlns = scanner.nextLine();
        String[] wlns = rwlns.split(", ");

        if (wlns.length != 6) {
            throw new IllegalArgumentException("로또 당첨 번호는 6개여야 합니다.");
        }

        Arrays.sort(wlns, Comparator.comparingInt(Integer::parseInt));

        System.out.println(Arrays.toString(wlns));

        /* 당첨번호랑 구매한 티켓의 로또 번호가 숫자가 몇개가 일치하는지 체크 */
        int threeMatchCnt = 0;
        int fourMatchCnt = 0;
        int fiveMatchCnt = 0;
        int sixMatchCnt = 0;

        for (int i = 0; i < lottoTicketSize; i++) {
            String[] lns = lottoTotalTicketNumbers[i];

            int cnt = 0;

            for (int j = 0; j < 6; j++) {
                String ln = lns[j];

                for (int k = 0; k < 6; k++) {
                    String wln = wlns[k];

                    if (ln.equals(wln)) {
                        cnt++;
                    }
                }
            }

            if (cnt == 3) {
                threeMatchCnt++;
            } else if (cnt == 4) {
                fourMatchCnt++;
            } else if (cnt == 5) {
                fiveMatchCnt++;
            } else if (cnt == 6) {
                sixMatchCnt++;
            }
        }


        int threeMatchWp = 5000;
        int fourMatchWp = 50000;
        int fiveMatchWp = 1500000;
        int sixMatchWp = 2000000000;

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + threeMatchWp + "원)- " + threeMatchCnt + "개");
        System.out.println("4개 일치 (" + fourMatchWp + "원)- " + fourMatchCnt + "개");
        System.out.println("5개 일치 (" + fiveMatchWp + "원)- " + fiveMatchCnt + "개");
        System.out.println("6개 일치 (" + sixMatchWp + "원)- " + sixMatchCnt + "개");

        long tWp = threeMatchWp * threeMatchCnt;
        tWp += fourMatchWp * fourMatchCnt;
        tWp += fiveMatchWp * fiveMatchCnt;
        tWp += sixMatchWp * sixMatchCnt;

        System.out.println("총 수익률은" + (tWp / totalAmount) + "입니다.");
    }


}
