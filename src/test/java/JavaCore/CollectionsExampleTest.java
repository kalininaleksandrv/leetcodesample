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
                new User(1, "Vasily", false, new Address(1, "Address1", 100)),
                new User(2, "Gleb", true, new Address(1, "Address1", 100)),
                new User(3, "Tanya", true, new Address(2, "Address2", 200)),
                new User(4, "Tanya", false, new Address(2, "Address2", 200)));

        incomingData2 = List.of(
                new User(1, "John", false, new Address(2, "Address2", 200)),
                new User(2, "Carl", true, new Address(3, "Address3", 300)),
                new User(3, "Jane", true, new Address(4, "Address4", 400)),
                new User(4, "Mariam", true, new Address(5, "Address5", 500)));
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
        assertTrue(res.containsKey(new Address(1, "Address1", 100)));
        assertEquals("Vasily---Gleb", res.get(new Address(1, "Address1", 100)));
    }

    @Test
    void groupingWithChangeValueClassType() {
        CollectionsExample collectionsExample = new CollectionsExample();
        Map<String, Set<Address>> res = collectionsExample.groupingWithChangeValueClassType(incomingData);
        assertEquals(3, res.size());
        assertEquals(1, res.get("Tanya").size()); //size = 1 because of set deduplication of addresses
    }

    @Test
    void groupByNameChangeToTreeMap() {
        CollectionsExample collectionsExample = new CollectionsExample();
        Map<String, List<User>> res = collectionsExample.groupByNameChangeToTreeMap(incomingData);
        List<String> keyList = res.keySet().stream().toList();
        assertEquals(3, res.size());
        assertEquals("Gleb", keyList.get(0)); //Gleb is first and Vasily is last because TreeMap is sorted
        assertEquals("Vasily", keyList.get(2));
    }

    @Test
    void mapFromUserList() {
        CollectionsExample collectionsExample = new CollectionsExample();
        Map<Integer, User> res = collectionsExample.mapFromUserList(incomingData);
        assertEquals(4, res.size());
    }


    @Test
    void mapFromUserListWithMerging() {
        CollectionsExample collectionsExample = new CollectionsExample();
        Map<String, User> res = collectionsExample.mapFromUserListWithMerging(incomingData);
        assertEquals(3, res.size()); //3 because only last "Tanya" remains
    }

    @Test
    void mapWithMergeAndSort() {
        CollectionsExample collectionsExample = new CollectionsExample();
        Map<String, User> res = collectionsExample.mapWithMergeAndSort(incomingData);
        List<String> keyList = res.keySet().stream().toList();
        assertEquals(3, res.size()); //3 because only last "Tanya" remains
        assertEquals("Gleb", keyList.get(0)); //Gleb is first and Vasily is last because TreeMap is sorted
        assertEquals("Vasily", keyList.get(2));
    }

    @Test
    void mapWithSortByKeyObj() {
        CollectionsExample collectionsExample = new CollectionsExample();
        Map<String, Integer> res =collectionsExample.mapWithSortByKeyObj(incomingData2);
        assertEquals(2, res.size());//2 because 2 is the limit
        assertTrue(res.values().stream().allMatch(i -> i>300));//remains only highest values 400 and 500
    }
}