package DynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BroadSearchTest {

    @Test
    void getShortestWay() {

        BroadSearch broadSearch = new BroadSearch();
        HashMap<String ,Integer> notBlockedMap = new HashMap<>();
        notBlockedMap.put("1:0", 0);
        notBlockedMap.put("1:1", 0);
        Map<String, Integer> res = broadSearch.getShortestWay(2, 2, 2, notBlockedMap, 0);
        assertTrue(res.containsKey("0:0"));

        HashMap<String ,Integer> blockedMap = new HashMap<>();
        blockedMap.put("1:0", 0);
        blockedMap.put("1:1", 0);
        blockedMap.put("1:2", 0);
        Map<String, Integer> res2 = broadSearch.getShortestWay(2, 2, 2, blockedMap, 0);
        assertFalse(res2.containsKey("0:0"));
    }
}