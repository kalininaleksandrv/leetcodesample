package ListAndMap;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubListsOfListTest {

    @Test
    void subLists() {
        List<List<?>> abc = SubListsOfList.of(List.of("a", "b", "c"));
        assertEquals(7, abc.size());
    }
}