package UtilityMethods;

import java.util.function.Function;

public abstract class UtilityHelper {

    static Function<Integer, String> converterFromIntToString(){
        System.out.println("converter was created");
        return String::valueOf;
    }
}
