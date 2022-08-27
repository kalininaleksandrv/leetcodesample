package JavaCore;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionalInterfaceExample {

    public int multiplyWithFunction(Function<Integer, Integer> func, int val) {
        return func.apply(val);
    }

    public int exponentWithBinaryOperator(BinaryOperator<Integer> exp, int val) {
        return exp.apply(val, val);
    }

    public String upperCaseWithUnaryOperator(UnaryOperator<String> operator, String income) {
        return operator.apply(income);
    }

    public String supplyNewStr(Supplier<String> supplier) {
        return supplier.get();
    }

    public void consumeWithConsumer(Consumer<String> consumer, String income) {
        consumer.accept(income);
    }

    public List<Integer> filterWithPredicate(Predicate<Integer> predicate, List<Integer> income) {
        return income
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

}
