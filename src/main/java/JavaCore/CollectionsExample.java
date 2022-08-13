package JavaCore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionsExample {

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
     * returns Address as a key and names of user, lives on specific address with delimiter
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
    public Map<String, Set<Address>> groupingByRegs(List<User> incomingData) {
        return incomingData
                .stream()
                .collect(Collectors.groupingBy(User::getName,
                        Collectors.mapping(User::getAddress, Collectors.toSet())));
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
}
