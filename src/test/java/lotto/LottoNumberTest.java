package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class LottoNumberTest {

    @Test
    void of_지정번호로_로또번호를_생성할수있다() {
        // given
        IntStream numbers = IntStream.rangeClosed(1, 45);

        // when, then
        numbers.forEach((number) -> assertDoesNotThrow(() ->
                LottoNumber.of(number)
        ));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 999, 10000})
    void of_지정번호가_로또번호의_범위를_벗어나면_에러(int number) {
        // given, when, then
        assertThrowsExactly(IllegalArgumentException.class, () -> LottoNumber.of(number), "로또번호는 1 ~ 45 범위의 값이어야 합니다.");
    }

    @Test
    void equals_로또번호값이같으면_같은객체로판단() {
        // given
        IntStream numbers = IntStream.rangeClosed(1, 45);

        // when, then
        numbers.forEach((number) -> {
            LottoNumber lottoNumber1 = LottoNumber.of(number);
            LottoNumber lottoNumber2 = LottoNumber.of(number);

            assertThat(lottoNumber1).isEqualTo(lottoNumber2);
        });
    }

    @Test
    void equals_로또번호값이다르면_다른객체로판단() {
        // given, when
        LottoNumber lottoNumber1 = LottoNumber.of(1);
        LottoNumber lottoNumber2 = LottoNumber.of(2);

        // then
        assertThat(lottoNumber1).isNotEqualTo(lottoNumber2);
    }

    @Test
    void get() {
        // given
        IntStream numbers = IntStream.rangeClosed(1, 45);

        // when, then
        numbers.forEach((number) -> {
            LottoNumber lottoNumber = LottoNumber.of(number);

            assertThat(lottoNumber.get()).isEqualTo(number);
        });
    }

    @Test
    void createRandom() {
        LottoNumber lottoNumber = LottoNumber.createRandom();

        assertThat(lottoNumber.get()).isGreaterThanOrEqualTo(1);
        assertThat(lottoNumber.get()).isLessThanOrEqualTo(45);
    }
}
