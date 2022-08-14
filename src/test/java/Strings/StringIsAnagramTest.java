package Strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringIsAnagramTest {

    @Test
    void isAnagram() {
        StringIsAnagram stringIsAnagram = new StringIsAnagram();
        boolean res1 = stringIsAnagram.isAnagram("anagram", "nagaram");
        boolean res2 = stringIsAnagram.isAnagram("car", "rat");
        assertTrue(res1);
        assertFalse(res2);
    }
}