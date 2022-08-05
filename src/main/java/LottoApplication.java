import java.util.*;

public class LottoApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int ta = Integer.parseInt(scanner.nextLine());
        System.out.println((ta / 1000) + "개를 구매했습니다.");

        String[][] lnss = new String[ta / 1000][6];
        int lnssSize = 0;

        for (int i = 0; i < ta / 1000; i++) {
            String[] lns = new String[6];
            int lnsSize = 0;

            while (lnsSize < 6) {
                String ln = String.valueOf(1 + new Random().nextInt(45));

                boolean dc = false;

                for (int j = 0; j < lnsSize; j++) {
                    if (ln.equals(lns[j])) {
                        dc = true;
                        break;
                    }
                }

                if (!dc) {
                    lns[lnsSize] = ln;
                    lnsSize++;
                }
            }

            Arrays.sort(lns, Comparator.comparingInt(Integer::parseInt));

            System.out.println(Arrays.toString(lns));

            lnss[lnssSize] = lns;
            lnssSize++;

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

        int threeMatchCnt = 0;
        int fourMatchCnt = 0;
        int fiveMatchCnt = 0;
        int sixMatchCnt = 0;

        for (int i = 0; i < lnssSize; i++) {
            String[] lns = lnss[i];

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

        System.out.println("총 수익률은" + (tWp / ta) + "입니다.");
    }
}
