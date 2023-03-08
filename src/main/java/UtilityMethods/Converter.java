package UtilityMethods;

import java.util.List;

import static UtilityMethods.UtilityHelper.converterFromIntToString;

public class Converter {

    List<Message> convert(List<String> from) {
        System.out.println("Invoke converter");
        /*
        converter creates lazy and only once
         */
        List<Message> stringList = from.stream()
                .map(converterFromIntToString())
                .toList();
        System.out.println("Result is " + stringList);
        return stringList;
    }
}
