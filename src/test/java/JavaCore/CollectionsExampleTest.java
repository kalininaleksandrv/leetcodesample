package JavaCore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

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

    @Test
    void letsFlatMap() {
        CollectionsExample collectionsExample = new CollectionsExample();
        List<User> res = collectionsExample.letsFlatMap(List.of(incomingData, incomingData2));
        assertEquals(8, res.size());//list of two lists 4 elements each was flattened to single 8-elements list
    }

    @Test
    void listFromMap() {
        CollectionsExample collectionsExample = new CollectionsExample();
        Map<String, User> userMap = collectionsExample.mapFromUserListWithMerging(incomingData);
        List<String> strings = collectionsExample.listFromMap(userMap);
        assertEquals(3, strings.size()); //3 because only last record with key "Tanya" remains
        assertTrue(strings.stream().allMatch(i -> i.contains("has a flat with address:")));
    }

    @Test
    void countAllMatchingValuesV1() {
        int[] countSource = new int[]{1, 2, 3, 100};
        CollectionsExample collectionsExample = new CollectionsExample();
        Integer res = collectionsExample.countAllMatchingValuesV1(countSource, 10);
        assertEquals(3, res); // all numbers > 10 will be discarded, others will be count
    }

    @Test
    void countAllMatchingValuesV2() {
        int[] countSource = new int[]{1, 2, 3, 100};
        CollectionsExample collectionsExample = new CollectionsExample();
        Integer res = collectionsExample.countAllMatchingValuesV2(countSource, 10);
        assertEquals(3, res); // all numbers > 10 will be discarded, others will be count
    }

    @Test
    void computeIfAbsentExample() {
        CollectionsExample collectionsExample = new CollectionsExample();
        Map<String, Integer> source = new HashMap<>();
        source.put("one", 3);
        source.put("two", 3); //map contains "one" and "two" but not "three"
        Map<String, Integer> res = collectionsExample.computeIfAbsentExample(source, "three");
        assertEquals(3, res.size());
        assertTrue(res.containsKey("three"));
        assertEquals(5, (int) res.get("three"));
    }

    @Test
    void computeIfAbsentExampleComplicated() {
        CollectionsExample collectionsExample = new CollectionsExample();
        Function<Integer, List<String>> integerToListString = integer -> {
            List<String> temp = new ArrayList<>();
            temp.add(String.valueOf(integer));
            return temp;
        }; //pass this function to method to compute value
        Map<Integer, List<String>> source = new HashMap<>();
        source.put(1, List.of("1"));
        source.put(2, List.of("2")); //map contains "one" and "two" but not "three"
        Map<Integer, List<String>> res = collectionsExample.computeIfAbsentExampleComplicated(source, 3, integerToListString);
        assertEquals(3, res.size());
        assertTrue(res.containsKey(3));
        assertEquals("3", res.get(3).get(0));
    }

    @Test
    void getStreamOfAllListElements() {
        CollectionsExample collectionsExample = new CollectionsExample();
        Stream<User> streamOfAllListElements = collectionsExample.getStreamOfAllListElements(incomingData);
        assertTrue(streamOfAllListElements.allMatch(e -> e.getId()<=4));
    }

    @Test
    void removeElementsFromList() {
        CollectionsExample collectionsExample = new CollectionsExample();
        assertThrows(UnsupportedOperationException.class, collectionsExample::removeElementsFromList);
    }

    @Test
    void removeElementsFromListV2() {
        CollectionsExample collectionsExample = new CollectionsExample();
        assertThrows(ConcurrentModificationException.class, collectionsExample::removeElementsFromListV2);
    }

    @Test
    void removeElementsFromListWithIterator() {
        CollectionsExample collectionsExample = new CollectionsExample();
        assertThrows(UnsupportedOperationException.class, collectionsExample::removeElementsFromListWithIterator);
    }

    @Test
    void removeElementsWithIteratorFail() {
        CollectionsExample collectionsExample = new CollectionsExample();
        assertThrows(ConcurrentModificationException.class, () -> collectionsExample
                .removeElementsWithIteratorFail(List.of("orange", "apple", "pineapple")));
    }

    @Test
    void removeElementsFromListWithIteratorAndWrapping() {
        CollectionsExample collectionsExample = new CollectionsExample();
        List<String> strings = collectionsExample
                .removeElementsWithIteratorSuccess(List.of("orange", "apple", "pineapple"));
        assertFalse(strings.contains("apple"));
        assertFalse(strings.contains("orange"));
        assertEquals(1, strings.size());
    }

    @Test
    void removeElementsWithFailSafeCollection() {
        CollectionsExample collectionsExample = new CollectionsExample();
        List<String> strings = collectionsExample.removeElementsWithFailSafeCollection();
        assertEquals(3, strings.size());
        assertFalse(strings.contains("pineapple"));
        assertTrue(strings.contains("grapefruit"));
    }
}