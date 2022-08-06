package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class LottoTicket {

     static final int LOTTO_TICKET_CONSISTENCY_SIZE = 6;

    public String[] generateLottoNumbers() {
        /* 로또번호 6개를 생성 */
        String[] lns = new String[6];
        int lnsSize = 0;
        while (lnsSize < LOTTO_TICKET_CONSISTENCY_SIZE) {
            String ln = String.valueOf(1 + new Random().nextInt(45));

            /* 중복체크 */
            boolean dc = false; // 생성한 로또번호가 겹치는지 체크하는 flag
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

        return lns;
    }
}
