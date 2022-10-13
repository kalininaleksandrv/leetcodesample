package Strings;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ValidTransactions {
    /*
     * Complete the 'processLogs' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY logs
     *  2. INTEGER threshold
     */

    public List<String> processLogs(List<String> logs, int threshold) {

        Map<String, Integer> usersMap = new TreeMap<>();
        for (String tr : logs) {
            String[] users = tr.split("\\s+");
            usersMap.putIfAbsent(users[0], 0);
            usersMap.put(users[0], usersMap.get(users[0]) + 1);
            if(users[0].equals(users[1])) {
                break;
            }
            usersMap.putIfAbsent(users[1], 0);
            usersMap.put(users[1], usersMap.get(users[1]) + 1);
        }

        return usersMap
                .entrySet()
                .stream()
                .filter(i -> i.getValue()>=threshold)
                .map(Map.Entry::getKey)
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.toList());

    }
}
