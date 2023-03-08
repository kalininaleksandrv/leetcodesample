package UtilityMethods;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterTest {

    @Test
    void convert() {
        Converter converter = new Converter();
        List<Message> stringList = converter.convert(List.of("one", "two", "three"));
        assertEquals(3, stringList.size());
    }
}