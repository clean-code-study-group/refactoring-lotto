package ui;

import lotto.LottoNumber;
import lotto.LottoNumbers;

import java.util.stream.Collectors;

public class LottoNumbersPrintText {
    private final LottoNumbers lottoNumbers;

    public LottoNumbersPrintText(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.getLottoNumbers()
                .stream()
                .map(LottoNumber::get)
                .collect(Collectors.toList())
                .toString();
    }
}
