package Strings;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PairsOfLoginsTest {

    @Test
    void countFamilyLogins() {
        PairsOfLogins pairsOfLogins = new PairsOfLogins();
        int i = pairsOfLogins.countFamilyLogins(List.of("bag", "sfe", "cbh", "cbh", "red"));
        assertEquals(3, i);
        int i2 = pairsOfLogins.countFamilyLogins(List.of("bag"));
        assertEquals(0, i2);
        int i3 = pairsOfLogins.countFamilyLogins(List.of(""));
        assertEquals(0, i3);
        int i4 = pairsOfLogins.countFamilyLogins(List.of("", ""));
        assertEquals(0, i4);
    }
}