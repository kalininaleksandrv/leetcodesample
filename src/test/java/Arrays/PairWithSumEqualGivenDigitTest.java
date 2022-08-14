package Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairWithSumEqualGivenDigitTest {

    @Test
    void hasPairWithSumEqualsGivenDigitVer1() {
        PairWithSumEqualGivenDigit pairWithSumEqualGivenDigit = new PairWithSumEqualGivenDigit();
        boolean res1 = pairWithSumEqualGivenDigit.hasPairWithSumEqualsGivenDigitVer1(new int[]{1, 2}, 3);
        boolean res2 = pairWithSumEqualGivenDigit.hasPairWithSumEqualsGivenDigitVer1(new int[]{1, 2}, 4);
        assertTrue(res1);
        assertFalse(res2);
    }
}