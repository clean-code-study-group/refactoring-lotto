package lotto;

import java.util.Random;

public class LottoNumber {
    static final int LOTTO_MINIMUM_NUMBER = 1;
    static final int LOTTO_MAXIMUM_NUMBER = 45;
    private static final Random RANDOM = new Random();
    private final int number;

    private LottoNumber(int number) {
        validNumber(number);
        this.number = number;
    }

    private void validNumber(int number) {
        if (number < LOTTO_MINIMUM_NUMBER || number > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(String.format("로또번호는 %d ~ %d 범위의 값이어야 합니다.", LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER));
        }
    }

    public int get() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    public static LottoNumber createRandom() {
        int randomNumber = LOTTO_MINIMUM_NUMBER + RANDOM.nextInt(LOTTO_MAXIMUM_NUMBER);
        return new LottoNumber(randomNumber);
    }
}
