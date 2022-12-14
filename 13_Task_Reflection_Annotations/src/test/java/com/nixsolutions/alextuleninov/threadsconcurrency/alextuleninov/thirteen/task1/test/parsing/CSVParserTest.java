package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.thirteen.task1.test.parsing;

import com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.thirteen.task1.parsing.CSVParser;
import com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.thirteen.task1.parsing.CSVTable;
import com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.thirteen.task1.test.ExampleForTestCSVTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class CSVParserTest {

    @Test
    void parse() throws URISyntaxException {

        var parser = new CSVParser();

        //Path path = Path.of("src/test/resources/magazine.csv");
        Path path = Paths.get(getClass().getResource("/magazine.csv").toURI());

        CSVTable table = parser.parse(path);
        List<List<String>> actual = table.getCsvTable();

        Assertions.assertEquals(ExampleForTestCSVTable.run(), actual);

    }

}
