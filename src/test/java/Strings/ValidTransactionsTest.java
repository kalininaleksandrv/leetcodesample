package Strings;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidTransactionsTest {

    @Test
    void processLogs() {
        ValidTransactions validTransactions = new ValidTransactions();
        List<String> strings = validTransactions.processLogs(List.of("99 88 200", "88 99 300", "88 88 100", "11 12 100"), 2);
        assertEquals(2, strings.size());
        List<String> strings2 = validTransactions.processLogs(List.of("9 8 200", "8 7 300", "6 5 100", "11 12 100"), 1);
        assertEquals(7, strings2.size());
    }
}