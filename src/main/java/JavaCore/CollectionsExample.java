package JavaCore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionsExample {

    /*
      ------------ GROUPING -----------------
     */

    /**
     * collector takes simple function as a param
     */
    public Map<String, List<User>> groupByName(List<User> incomingData){
        return incomingData
                .stream()
                .collect(Collectors.groupingBy(User::getName));
    }

    /**
     * collector takes 2 param - function to extract key from User and downstream collector which reduce value by counting
     */
    public Map<Boolean, Long> groupingAndCounting(List<User> incomingData) {
        return incomingData
                .stream()
                .collect(Collectors.groupingBy(User::isRegistered, Collectors.counting()));
    }

    /**
     * collector takes 2 param - function to extract key from User and Collector.mapping whih joining
     * returns Address as a key and names of user, who lives on specific address with delimiter
     */
    public Map<Address, String> groupingAndMapping(List<User> incomingData) {
        return incomingData.stream()
                .collect(Collectors.groupingBy(User::getAddress,
                        Collectors.mapping(User::getName, Collectors.joining("---"))));
    }

    /**
     * collector takes 2 param - function to extract key from User and Collector.mapping which turns User to Address
     * after mapping second collector turns result to set fore deduplication
     */
    public Map<String, Set<Address>> groupingWithChangeValueClassType(List<User> incomingData) {
        return incomingData
                .stream()
                .collect(Collectors.groupingBy(User::getName,
                        Collectors.mapping(User::getAddress, Collectors.toSet())));
    }

    /**
     * Collector with third parameter lets you specify the type of map
     * f.e. in this case we're specified TreeMap for sorting
     */
    public Map<String, List<User>> groupByNameChangeToTreeMap(List<User> incomingData) {
        return incomingData.stream().collect(Collectors.groupingBy(User::getName, TreeMap::new, Collectors.toList()));
    }

    /*
      ------------ COLLECTORS.toMAP -----------------
     */

    /**
     * simple map from list
     */
    public Map<Integer, User> mapFromUserList(List<User> incomingData) {
        return incomingData
                .stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
    }

    /**
     * when we find the same value the merge function works with defined rules (specifically here - last value remains)
     */
    public Map<String, User> mapFromUserListWithMerging(List<User> incomingData) {
        return incomingData
                .stream()
                .collect(Collectors.toMap(
                        User::getName,
                        Function.identity(),
                        (oldone, newone) -> newone
                ));
    }

    /**
     * the same as a previous - merging values but also sort the map
     */
    public Map<String, User> mapWithMergeAndSort(List<User> incomingData) {
        return incomingData
                .stream()
                .collect(Collectors.toMap(
                        User::getName,
                        Function.identity(),
                        (oldest, newest) -> newest,
                        TreeMap::new
                ));
    }

    /**
     * what if we need to remain only N first users sorting in a Address rent price order as a map <Username, Rent_price>
     */

    public Map<String, Integer> mapWithSortByKeyObj(List<User> incomingData) {
        return incomingData
                .stream()
                .sorted((s1, s2) -> {
                    if (s1 == s2) return 0;
                    return (s1.getAddress().getRentPrice()>s2.getAddress().getRentPrice()?-1:1);
                })
                .limit(2)
                .collect(Collectors.toMap(i -> i.getId() + i.getName(), i -> i.getAddress().getRentPrice()));
    }

    /*
      ------------ MAP AND FLATMAP -----------------
     */

    public List<User> letsFlatMap(List<List<User>> incomingDataMessed) {
        return incomingDataMessed
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<String> listFromMap(Map<String, User> map) {

        return map
                .entrySet()
                .stream()
                .map(e -> e.getKey() + " has a flat with address: " + e.getValue().getAddress().getStreet())
                .collect(Collectors.toList());
    }

    private void iterationOverMap(Map<Integer, User> userMap) {
        // simple entry set
        for (Map.Entry<Integer, User> entry: userMap.entrySet()){
            System.out.println(entry.getKey()+"---"+entry.getValue().getName());
        }
        // get key and then get value with key
        for (Integer key: userMap.keySet()){
            System.out.println(userMap.get(key).getName());
        }
        // use iterator
        Iterator<Map.Entry<Integer,User>> iterator = userMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, User> next = iterator.next();
            System.out.println(next.getValue().getName());
        }
        //stream forEach
        userMap.forEach((k, v) -> System.out.println(k + "---" + v.getName()));
        //stream from entrySet
        userMap.entrySet()
                .stream()
                .map(i -> i.getKey() + " is ID of user with name " + i.getValue().getName())
                .forEach(System.out::println);
        //stream from values
        userMap.values()
                .stream()
                .map(User::getName)
                .forEach(System.out::println);

    }

    /*
      ------------ WORK WITH ARRAYS -----------------
     */

    public Integer countAllMatchingValuesV1(int[] myArrayOfInts, int val) {
        return Math.toIntExact(IntStream.range(0, myArrayOfInts.length)
                .filter(i -> myArrayOfInts[i] < val)
                .count());
    }

    public Integer countAllMatchingValuesV2(int[] myArrayOfInts, int val) {
        return Arrays
                .stream(myArrayOfInts)
                .filter(i -> i < val)
                .map(e -> 1)
                .reduce(0, Integer::sum);
    }



}

@Data
@RequiredArgsConstructor
@AllArgsConstructor
class User {
    int id;
    String name;
    public boolean isRegistered;
    public Address address;
}

@Data
@AllArgsConstructor
class Address {
    int id;
    String street;
    int rentPrice;
}
