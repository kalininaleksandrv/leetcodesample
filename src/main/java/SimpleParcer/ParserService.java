package SimpleParcer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserService {

    public void parse(String pathToFile) {
        try {
            //from arbitrary file
            Stream<String> lines = new BufferedReader(new FileReader(pathToFile)).lines();
            Map<String,String> collect = lines.map(line -> line.split(":"))
                    .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
            System.out.println(collect);
            // form application.properties
            String path = Objects.requireNonNull(ClassLoader.getSystemClassLoader()
                    .getResource("application.properties")).getPath();
            Stream<String> linesFromApProp = new BufferedReader(new FileReader(path)).lines();
            Map<String, String> collectFromAppProp = linesFromApProp
                    .map(line -> line.split("=")).collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
            System.out.println(collectFromAppProp);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
