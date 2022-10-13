package Strings;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankOfTheStudentsTest {

    @Test
    void findTotalImbalance() {
        RankOfTheStudents rank = new RankOfTheStudents();
        long totalImbalance = rank.findTotalImbalance(List.of(1, 2, 3, 4));
        assertEquals(0, totalImbalance);
        long totalImbalance2 = rank.findTotalImbalance(List.of(1, 2, 5, 6));
        assertEquals(4, totalImbalance2);
    }
}