package DivideAndConquer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMaxInUnimodalArrayTest {

    @Test
    void getMaxFromArray() {
        FindMaxInUnimodalArray findMaxInUnimodalArray = new FindMaxInUnimodalArray();
        int res1 = findMaxInUnimodalArray.getMaxFromArray(new int[]{1, 2, 3, 4, 9, 7, 3, 2});
        int res2 = findMaxInUnimodalArray.getMaxFromArray(new int[]{0});
        int res3 = findMaxInUnimodalArray.getMaxFromArray(new int[]{1,1,1,1,1,1});
        int res4 = findMaxInUnimodalArray.getMaxFromArray(new int[]{1, 2, 3, 4, 7, 9, 10});
        int res5 = findMaxInUnimodalArray.getMaxFromArray(new int[]{});

        assertEquals(9, res1);
        assertEquals(0, res2);
        assertEquals(1, res3);
        assertEquals(10, res4);
        assertEquals(-1, res5);
    }
}