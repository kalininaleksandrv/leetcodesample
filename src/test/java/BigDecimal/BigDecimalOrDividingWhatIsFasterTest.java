package BigDecimal;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BigDecimalOrDividingWhatIsFasterTest {

    @Test
    void exchange() {
        BigDecimalOrDividingWhatIsFaster bd = new BigDecimalOrDividingWhatIsFaster();
        String exchange = bd.exchange(100, Currency.USD, Currency.EUR);
        String exchangeBd = bd.exchangeBD(100, Currency.EUR, Currency.USD);
        assertEquals("95.0", exchange);
        assertEquals("115.00", exchangeBd);

        Random rn = new Random();
        long start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++){
            bd.exchange(rn.nextInt(1, Integer.MAX_VALUE), Currency.USD, Currency.EUR);
        }
        for (int i = 0; i < 1_000_000; i++){
            bd.exchange(rn.nextInt(1, Integer.MAX_VALUE), Currency.EUR, Currency.USD);
        }
        long finish = System.nanoTime();
        System.out.println("it takes " + (finish-start)/1000000 + " ms without Big decimal");

        long start2 = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++){
            bd.exchangeBD(rn.nextInt(1, Integer.MAX_VALUE), Currency.USD, Currency.EUR);
        }
        for (int i = 0; i < 1_000_000; i++){
            bd.exchangeBD(rn.nextInt(1, Integer.MAX_VALUE), Currency.EUR, Currency.USD);
        }
        long finish2 = System.nanoTime();
        System.out.println("it takes " + (finish2-start2)/1000000 + " ms with Big decimal");
    }
}