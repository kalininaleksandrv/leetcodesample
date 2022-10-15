package SimpleParcer;

import org.junit.jupiter.api.Test;

class ParserServiceTest {

    @Test
    void parse() {
        ParserService parserService = new ParserService();
        parserService.parse("src/main/java/SimpleParcer/props.txt");
        //check console to see result of parsing
    }
}