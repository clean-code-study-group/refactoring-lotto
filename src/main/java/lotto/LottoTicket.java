package lotto;

import java.util.*;

public class LottoTicket extends LottoNumbers {

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    @Override
    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    private static List<LottoNumber> generateLottoNumbers() {
        Set<LottoNumber> lottoNumbers = new TreeSet<>(Comparator.comparingInt(LottoNumber::get));

        while (lottoNumbers.size() < LOTTO_NUMBERS_CONSISTENCY_SIZE) {
            lottoNumbers.add(LottoNumber.createRandom());
        }

        return new ArrayList<>(lottoNumbers);
    }

    public static LottoTicket create() {
        List<LottoNumber> lottoNumbers = generateLottoNumbers();

        return new LottoTicket(lottoNumbers);
    }
}
