package UtilityMethods;

import java.util.function.Function;

public abstract class UtilityHelper {

    static Function<String, Message> converterFromIntToString(){
        System.out.println("converter was created");
        return Message::new;
    }
}
