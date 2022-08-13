package DynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {

    @Test
    void climbStairs() {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        assertEquals(1, climbingStairs.climbStairs(1, new HashMap<>()));
        assertEquals(3, climbingStairs.climbStairs(3, new HashMap<>()));
        assertEquals(1836311903, climbingStairs.climbStairs(45, new HashMap<>()));
    }
}