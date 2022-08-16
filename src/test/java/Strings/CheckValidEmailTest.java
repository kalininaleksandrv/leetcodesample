package Strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckValidEmailTest {

    @Test
    void isValidEmail() {
        String email1 = "some@some.com";
        String email2 = "some.guy@some.eu";
        String email3 = "domain@but@wrong.com";
        String email4 = "domain@wrong.a";
        String email5 = "domain@corr.rect.com";
        String email6 = "do#main@corr.rect.com";
        String email7 = "do3main@corr.rect.com";

        CheckValidEmail checkValidEmail = new CheckValidEmail();
        assertTrue(checkValidEmail.isValidEmail(email1));
        assertTrue(checkValidEmail.isValidEmail(email2));
        assertFalse(checkValidEmail.isValidEmail(email3));
        assertFalse(checkValidEmail.isValidEmail(email4));
        assertTrue(checkValidEmail.isValidEmail(email5));
        assertFalse(checkValidEmail.isValidEmail(email6));
        assertTrue(checkValidEmail.isValidEmail(email7));
    }
}