package UtilityMethods;

import java.util.List;

import static UtilityMethods.UtilityHelper.converterFromIntToString;

public class Converter {

    List<String> convert(List<Integer> from) {
        System.out.println("Invoke converter");
        /*
        converter creates lazy and only once
         */
        List<String> stringList = from.stream()
                .map(converterFromIntToString())
                .toList();
        System.out.println("Result is " + stringList);
        return stringList;
    }
}
