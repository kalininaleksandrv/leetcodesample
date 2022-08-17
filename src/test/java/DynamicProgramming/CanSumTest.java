package DynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanSumTest {

    @Test
    void isSum() {
        CanSum canSum = new CanSum();
        assertTrue(canSum.isSum(7, new int[]{3,4,9}));
        assertFalse(canSum.isSum(7, new int[]{3,5,9}));
        assertTrue(canSum.isSum(7, new int[]{2,3}));
        assertFalse(canSum.isSum(1, new int[]{2,2,2}));
    }
}