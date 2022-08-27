package JavaCore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcurrencyExampleTest {

    @Test
    void exampleOfSync() {
        ConcurrencyExample concurrencyExample = new ConcurrencyExample();
        int res = concurrencyExample.exampleOfSync();
        assertEquals(1, res);
    }
}