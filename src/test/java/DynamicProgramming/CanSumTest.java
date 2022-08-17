package DynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CanSumTest {

    @Test
    void isSum() {
        CanSum canSum = new CanSum();
        assertTrue(canSum.isSum(7, new int[]{3,4,9}, new HashMap<>()));
        assertFalse(canSum.isSum(7, new int[]{3,5,9}, new HashMap<>()));
        assertTrue(canSum.isSum(7, new int[]{2,3}, new HashMap<>()));
        assertTrue(canSum.isSum(200, new int[]{2,2,2}, new HashMap<>()));
    }
}