package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class WinningLottoNumbers extends LottoNumbers {
    private WinningLottoNumbers(List<LottoNumber> lottoNumbers) {
        super(new LinkedHashSet<>(lottoNumbers));
    }

    private boolean isMatch(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int countMatches(LottoNumbers lottoNumbers) {
        return (int) lottoNumbers.getLottoNumbers()
                .stream()
                .filter(this::isMatch)
                .count();
    }

    @Override
    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    public static WinningLottoNumbers from(String[] rawLottoNumbers) {
        List<LottoNumber> sortedLottoNumbers = Arrays.stream(rawLottoNumbers)
                .map(Integer::parseInt)
                .sorted()
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        return new WinningLottoNumbers(sortedLottoNumbers);
    }
}
