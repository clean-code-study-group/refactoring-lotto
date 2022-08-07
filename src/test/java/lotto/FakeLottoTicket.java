package lotto;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class FakeLottoTicket extends LottoNumbers {
    private FakeLottoTicket(Collection<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    @Override
    public Collection<LottoNumber> getLottoNumbers() {
        return super.getLottoNumbers();
    }

    public static FakeLottoTicket of(int... numbers) {
        return new FakeLottoTicket(Arrays.stream(numbers).mapToObj(LottoNumber::of).collect(Collectors.toList()));
    }
}
