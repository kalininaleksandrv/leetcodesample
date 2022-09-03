package DivideAndConquer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindFirstAndLastOccurrenceTest {

    @Test
    void getFirstAndLastOcc() {
        FindFirstAndLastOccurrence findFirstAndLastOccurrence = new FindFirstAndLastOccurrence();
        int[] firstAndLastOccV6 = findFirstAndLastOccurrence.getFirstAndLastOcc(new int[]{1,1,1,2,2}, 2);
        assertEquals(3, firstAndLastOccV6[0]);
        assertEquals(4, firstAndLastOccV6[1]);

        int[] firstAndLastOccV1 = findFirstAndLastOccurrence.getFirstAndLastOcc(new int[]{1,2,2,2,3}, 2);
        assertEquals(1, firstAndLastOccV1[0]);
        assertEquals(3, firstAndLastOccV1[1]);

        int[] firstAndLastOccV2 = findFirstAndLastOccurrence.getFirstAndLastOcc(new int[]{1,1,2,2,3}, 2);
        assertEquals(2, firstAndLastOccV2[0]);
        assertEquals(3, firstAndLastOccV2[1]);

        int[] firstAndLastOccV3 = findFirstAndLastOccurrence.getFirstAndLastOcc(new int[]{1,1,1,1,1}, 2);
        assertEquals(-1, firstAndLastOccV3[0]);
        assertEquals(-1, firstAndLastOccV3[1]);

        int[] firstAndLastOccV4 = findFirstAndLastOccurrence.getFirstAndLastOcc(new int[]{3,3,3,3,3}, 2);
        assertEquals(-1, firstAndLastOccV4[0]);
        assertEquals(-1, firstAndLastOccV4[1]);

        int[] firstAndLastOccV5 = findFirstAndLastOccurrence.getFirstAndLastOcc(new int[]{1,1,1,1,2}, 2);
        assertEquals(4, firstAndLastOccV5[0]);
        assertEquals(4, firstAndLastOccV5[1]);
    }
}