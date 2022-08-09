package lotto;

import java.util.Collection;

public abstract class LottoNumbers {
    protected static final int LOTTO_NUMBERS_CONSISTENCY_SIZE = 6;

    protected LottoNumbers(Collection<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_CONSISTENCY_SIZE) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d개여야 합니다.", LOTTO_NUMBERS_CONSISTENCY_SIZE));
        }

        this.lottoNumbers = lottoNumbers;
    }

    protected Collection<LottoNumber> lottoNumbers;

    public Collection<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
