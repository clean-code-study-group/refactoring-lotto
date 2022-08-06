package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {

    static final int LOTTO_MAX_NUMBER = 45;

    static final int LOTTO_TICKET_CONSISTENCY_SIZE = 6;

    List<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = generateLottoNumbers();
    }

    public LottoTicket(String[] rawLottoNumbers) {
        this.lottoNumbers = Arrays.stream(rawLottoNumbers).map(Integer::parseInt).sorted().collect(Collectors.toList());
    }

    public List<Integer> generateLottoNumbers() {
        /* 로또번호 6개를 생성 */
        List<Integer> lottoNumbers = new ArrayList<>();
        int lottoNumbersSize = 0;

        while (lottoNumbersSize < LOTTO_TICKET_CONSISTENCY_SIZE) {
            int lottoNumber = 1 + new Random().nextInt(LOTTO_MAX_NUMBER);

            /* 중복체크 */
            boolean dc = false; // 생성한 로또번호가 겹치는지 체크하는 flag
            for (int j = 0; j < lottoNumbersSize; j++) {
                if (lottoNumber == lottoNumbers.get(j)) {
                    dc = true;
                    break;
                }
            }

            if (!dc) {
                lottoNumbers.add(lottoNumber);
                lottoNumbersSize++;
            }
        }

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
