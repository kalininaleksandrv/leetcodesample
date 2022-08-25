package ListAndMap;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubListsOfList {

    /*
    this method returns all combinations of elements of given list
    f.e. for List.of("a", "b", "c") it returns list of 7 lists,
    [], [a], [a,b], [b], [a,b,c], [b,c], [c]
    ---
    first we're creates stream of all start sequences in prefix() method
    for example [a], [a, b], [a, b, c]
    then we return for each stream value for itself and subsequences
    each contains all variant of ending
     for example for [a] it will be [a] itself
     for [a, b, c] it will be [a, b, c] itself and also [b, c], [c]
     finally we concatenate empty stream with this stream
    it takes us empty sequence first
     */

    public static <E> List<List<?>> of (List<E> list){
        return Stream.concat(Stream.of(Collections.emptyList()),
                prefixes(list)
                        .flatMap(SubListsOfList::suffixes))
                .collect(Collectors.toList());
    }
    /*
    returns stream of Lists - each contains one element of starting list
    for example for List.of("a", "b", "c") it returns stream of 3 lists [a], [a, b], [a, b, c]
     */
    private static <E> Stream<List<E>> prefixes (List<E> list){
        return IntStream.rangeClosed(1, list.size())
                .mapToObj(end -> list.subList(0, end));
    }

    /*
    return sublist of given list reduce for one element by step
    for example for List.of("a", "b", "c") returns [a, b, c], [b, c], [c]
     */
    private static <E> Stream<List<E>> suffixes (List<E> list){
        return IntStream.range(0, list.size())
                .mapToObj(start -> list.subList(start, list.size()));
    }

}
