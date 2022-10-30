package JavaCore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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
      ------------ MAP FLATMAP ITERATION -----------------
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

    public <E> Stream<E> getStreamOfAllListElements (List<E> list) {
        return IntStream.rangeClosed(0, list.size()-1).mapToObj(list::get);
    }

    public <T> List<T> collectionFromIterable(Iterable<T> iterable){
        return StreamSupport.stream(iterable.spliterator(), false).toList();
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

    /*
      ------------ COMPUTE IF ABSENT -----------------
     */

    /**
     * in this variant we put function directly to method computeIfAbsent as a lambda or method reference
     */
    public Map<String, Integer> computeIfAbsentExample(Map<String, Integer> source, String key){
        source.computeIfAbsent(key, String::length); //method itself returns computing value, NOT map
        return source;
    }

    /**
     * in this variant we put function directly to method as a function, it helps when function is complicated
     */
    public  Map<Integer, List<String>> computeIfAbsentExampleComplicated(Map<Integer, List<String>> source,
                                                                         Integer key,
                                                                         Function<Integer, List<String>> computer){
        source.computeIfAbsent(key, computer); //method itself returns computing value, NOT map
        return source;
    }

    /*
    ------------ FAIL FAST --------------
     */

    List<String> removeElementsFromList() {
        List<String> income = List.of("orange", "apple", "pineapple");
        // throw an UnsupportedOperationException since List.of implementation might not be an ArrayList
        income.removeIf(s -> s.equals("orange"));
        return income;
    }

    List<String> removeElementsFromListV2() {
        List<String> income = new ArrayList<>(List.of("orange", "apple", "pineapple"));
        // throw an ConcurrentModificationException since we try to modify origin ArrayList from inside the loop
        for (String s:income) {
            income.remove(s);
        }
        return income;
    }

    List<String> removeElementsFromListWithIterator() {
        List<String> income = List.of("orange", "apple", "pineapple");
        // throw an UnsupportedOperationException since List.of implementation might not be an ArrayList
        Iterator<String> firstListIterator = income.iterator();
        while (firstListIterator.hasNext()){
            if(firstListIterator.next().equals("apple")){
                firstListIterator.remove();
            }
        }
        return income;
    }

    List<String> removeElementsWithIteratorFail(List<String> income) {
        // wrap with ArrayList to get rid of UnsupportedOperationException
        List<String> wrapped = new ArrayList<>(income);
        Iterator<String> iterator = wrapped.iterator();
        // throw an ConcurrentModificationException since we try to modify origin ArrayList from inside the loop
        while (iterator.hasNext()) {
            if (iterator.next().equals("pineapple")){
                wrapped.remove("pineapple");
            }
        }
        // wrapped.removeIf(s -> s.equals("orange")) also will throw CME
        return wrapped;
    }

    List<String> removeElementsWithIteratorSuccess(List<String> income) {
        List<String> wraped = new ArrayList<>(income);
        Iterator<String> firstListIterator = wraped.iterator();
        // after wrapping iterator will not throw exception
        while (firstListIterator.hasNext()){
            if(firstListIterator.next().equals("apple")){
                //here we invoke iterator NOT original collection
                //and operation will succeed
                firstListIterator.remove();
            }
        }
        // and this way of removing also not throw an exception
        income.removeIf(s -> s.equals("orange"));

        // we can't deal with "add" problem call iterator instead of collection,
        // as we do with remove, because iterator have not an add()-method
        // so use FAIL-SAFE collections to fix problem

        return wraped;
    }

    /*
    ------------ FAIL SAFE --------------
     */

    List<String> removeElementsWithFailSafeCollection() {
        List<String> example = new CopyOnWriteArrayList<>();
        example.add("orange");
        example.add("apple");
        example.add("pineapple");

        for (String s : example) {
            if (s.equals("pineapple")) {
                // will NOT throw Exception, since it a failsafe
                example.remove("pineapple");
                //adn we can add also
                example.add("grapefruit");
            }
        }
        return example;
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
