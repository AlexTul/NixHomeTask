package com.nixsolutions.alextuleninov.thirteen.task1.test.parsing;

import com.nixsolutions.alextuleninov.thirteen.task1.parsing.CSVParser;
import com.nixsolutions.alextuleninov.thirteen.task1.parsing.CSVTable;
import com.nixsolutions.alextuleninov.thirteen.task1.test.ExampleForTestCSVTable;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVParserTest {

    @Test
    void parse() {

        var parser = new CSVParser();

        Path path = Path.of("example/magazine.csv");

        CSVTable table = parser.parse(path);
        List<List<String>> actual = table.getCsvTable();

        assertEquals(ExampleForTestCSVTable.run(), actual);

    }

}
