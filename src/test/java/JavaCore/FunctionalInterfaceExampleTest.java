package JavaCore;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.*;

import static org.junit.jupiter.api.Assertions.*;

class FunctionalInterfaceExampleTest {

    @Test
    void multiplyWithFunction() {
        FunctionalInterfaceExample functionalInterfaceExample = new FunctionalInterfaceExample();
        Function<Integer, Integer> exponentiation = i -> i*i;
        int res = functionalInterfaceExample.multiplyWithFunction(exponentiation, 3);
        assertEquals(9, res);
    }

    @Test
    void testMultiplyComposeAdd() {
        FunctionalInterfaceExample functionalInterfaceExample = new FunctionalInterfaceExample();
        Function<Integer, Integer> multiply = value -> value * 2;
        Function<Integer, Integer> add = value -> value + 3;
        //first called composed function (+3), then multiplication (3+3)*2
        Function<Integer, Integer> compose = multiply.compose(add);
        int res = functionalInterfaceExample.multiplyWithFunction(compose, 3);
        assertEquals(12, res);
    }

    @Test
    void multiplyAndThenAdd() {
        FunctionalInterfaceExample functionalInterfaceExample = new FunctionalInterfaceExample();
        Function<Integer, Integer> multiply = value -> value * 2;
        Function<Integer, Integer> add = value -> value + 3;
        // first "apply" works and second "andThen" 3+(3*2)
        Function<Integer, Integer> compose = multiply.andThen(add);
        int res = functionalInterfaceExample.multiplyWithFunction(compose, 3);
        assertEquals(9, res);
    }

    @Test
    void exponentWithBinaryOperator() {
        FunctionalInterfaceExample functionalInterfaceExample = new FunctionalInterfaceExample();
        BinaryOperator<Integer> operator = (i, k) -> i*k;
        int res = functionalInterfaceExample.exponentWithBinaryOperator(operator, 3);
        assertEquals(9, res);
    }

    @Test
    void upperCaseWithUnaryOperator() {
        FunctionalInterfaceExample functionalInterfaceExample = new FunctionalInterfaceExample();
        UnaryOperator<String> operator = String::toUpperCase;
        String test = functionalInterfaceExample.upperCaseWithUnaryOperator(operator, "test");
        assertEquals("TEST", test);
    }


    @Test
    void supplyNewStr() {
        FunctionalInterfaceExample functionalInterfaceExample = new FunctionalInterfaceExample();
        String str = "my string";
        Supplier<String> supplier = str::toUpperCase;
        String res = functionalInterfaceExample.supplyNewStr(supplier);
        assertEquals("MY STRING", res);
    }


    @Test
    void consumeWithConsumer() {
        FunctionalInterfaceExample functionalInterfaceExample = new FunctionalInterfaceExample();
        Consumer<String> consumer = System.out::println;
        // "consumable string will be print via console"
        functionalInterfaceExample.consumeWithConsumer(consumer, "----> consumable string");
    }

    @Test
    void filterWithPredicate() {
        FunctionalInterfaceExample functionalInterfaceExample = new FunctionalInterfaceExample();
        Predicate<Integer> isEven = value -> value%2 == 1;
        Predicate<Integer> isOdd = value -> value%2 == 0;
        List<Integer> digits = List.of(1,2);
        List<Integer> evens = functionalInterfaceExample.filterWithPredicate(isEven, digits);
        assertTrue(evens.contains(1));
        assertFalse(evens.contains(2));
        List<Integer> odds = functionalInterfaceExample.filterWithPredicate(isOdd, digits);
        assertTrue(odds.contains(2));
        assertFalse(odds.contains(1));
    }
}