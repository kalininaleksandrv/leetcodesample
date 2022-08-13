package JavaCore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CollectionsExampleTest {
    List<User> incomingData, incomingData2;

    @BeforeEach
    void setUp() {
        incomingData = List.of(
                new User(1, "Vasily", false, new Address(1, "Addres1")),
                new User(2, "Gleb", true, new Address(1, "Addres1")),
                new User(3, "Tanya", true, new Address(1, "Addres2")),
                new User(4, "Tanya", false, new Address(1, "Addres2")));

        incomingData2 = List.of(
                new User(1, "John", false, new Address(1, "Addres2")),
                new User(2, "Carl", true, new Address(1, "Addres3")));
    }

    @Test
    void groupByName() {
        CollectionsExample collectionsExample = new CollectionsExample();
        Map<String, List<User>> res = collectionsExample.groupByName(incomingData);
        assertEquals(3, res.size());
        assertTrue(res.containsKey("Tanya"));
        assertTrue(res.containsKey("Vasily"));
        assertTrue(res.containsKey("Gleb"));
        assertEquals(2, res.get("Tanya").size());
        assertEquals(1, res.get("Vasily").size());
        assertEquals(1, res.get("Gleb").size());
    }

    @Test
    void groupingAndCounting() {
        CollectionsExample collectionsExample = new CollectionsExample();
        Map<Boolean, Long> res = collectionsExample.groupingAndCounting(incomingData);
        assertEquals(2, res.size());
        assertTrue(res.containsKey(true));
        assertTrue(res.containsKey(false));
        assertEquals(2, res.get(true));
        assertEquals(2, res.get(false));
    }

    @Test
    void groupingAndMapping() {

        CollectionsExample collectionsExample = new CollectionsExample();
        Map<Address, String> res = collectionsExample.groupingAndMapping(incomingData);
        assertEquals(2, res.size());
        assertTrue(res.containsKey(new Address(1, "Addres1")));
        assertEquals("Vasily---Gleb", res.get(new Address(1, "Addres1")));
    }

    @Test
    void groupingByRegs() {
        CollectionsExample collectionsExample = new CollectionsExample();
        Map<String, Set<Address>> res = collectionsExample.groupingByRegs(incomingData);
        assertEquals(3, res.size());
        assertTrue(res.containsKey("Tanya"));
        assertEquals(1, res.get("Tanya").size());
    }
}