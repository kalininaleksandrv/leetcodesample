package SimpleParcer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserService {

    public void parse(String pathToFile) {
        try {
            Stream<String> lines = new BufferedReader(new FileReader(pathToFile)).lines();
            Map<String,String> collect = lines.map(line -> line.split(":"))
                    .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
            System.out.println(collect);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
