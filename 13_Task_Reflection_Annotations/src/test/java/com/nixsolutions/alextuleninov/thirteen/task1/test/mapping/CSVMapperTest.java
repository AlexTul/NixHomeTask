package com.nixsolutions.alextuleninov.thirteen.task1.test.mapping;

import com.nixsolutions.alextuleninov.thirteen.task1.mapping.CSVMapper;
import com.nixsolutions.alextuleninov.thirteen.task1.parsing.CSVParser;
import com.nixsolutions.alextuleninov.thirteen.task1.parsing.CSVTable;
import com.nixsolutions.alextuleninov.thirteen.task1.test.ExampleForTestCSVTable;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CSVMapperTest {

    private static final String CLASS_NAME = "AppCSVTable";

    @Test
    void map() {

        CSVParser parser = new CSVParser();
        Path path = Path.of("example/magazine.csv");
        CSVTable csvTable = parser.parse(path);

        CSVMapper csvMapper = new CSVMapper();

        List<AppCSVTable> appCSVTable = csvMapper.map(csvTable, AppCSVTable.class);

        assertEquals(ExampleForTestCSVTable.getRow1().get(0), appCSVTable.get(0).name);
        assertEquals(ExampleForTestCSVTable.getRow1().get(1), String.valueOf(appCSVTable.get(0).sex));
        assertEquals(ExampleForTestCSVTable.getRow1().get(2), String.valueOf(appCSVTable.get(0).age));
        assertEquals(ExampleForTestCSVTable.getRow1().get(3), String.valueOf(appCSVTable.get(0).growth));
        assertEquals(ExampleForTestCSVTable.getRow1().get(4), String.valueOf(appCSVTable.get(0).weight));
        assertEquals(ExampleForTestCSVTable.getRow1().get(5), String.valueOf(appCSVTable.get(0).agreement));

        assertEquals(ExampleForTestCSVTable.getRow2().get(0), appCSVTable.get(1).name);
        assertEquals(ExampleForTestCSVTable.getRow2().get(1), String.valueOf(appCSVTable.get(1).sex));
        assertEquals(ExampleForTestCSVTable.getRow2().get(2), String.valueOf(appCSVTable.get(1).age));
        assertEquals(ExampleForTestCSVTable.getRow2().get(3), String.valueOf(appCSVTable.get(1).growth));
        assertEquals(ExampleForTestCSVTable.getRow2().get(4), String.valueOf(appCSVTable.get(1).weight));
        assertEquals(ExampleForTestCSVTable.getRow2().get(5), String.valueOf(appCSVTable.get(1).agreement));

        assertEquals(ExampleForTestCSVTable.getRow3().get(0), appCSVTable.get(2).name);
        assertEquals(ExampleForTestCSVTable.getRow3().get(1), String.valueOf(appCSVTable.get(2).sex));
        assertEquals(ExampleForTestCSVTable.getRow3().get(2), String.valueOf(appCSVTable.get(2).age));
        assertEquals(ExampleForTestCSVTable.getRow3().get(3), String.valueOf(appCSVTable.get(2).growth));
        assertEquals(ExampleForTestCSVTable.getRow3().get(4), String.valueOf(appCSVTable.get(2).weight));
        assertEquals(ExampleForTestCSVTable.getRow3().get(5), String.valueOf(appCSVTable.get(2).agreement));

        for (int i = 0; i < csvTable.getCsvTable().size() - 1; i++) {
            out.println(CLASS_NAME + "" + i + ".name: " + appCSVTable.get(i).name);
            out.println(CLASS_NAME + i + ".sex: " + appCSVTable.get(i).sex);
            out.println(CLASS_NAME + i + ".age: " + appCSVTable.get(i).age);
            out.println(CLASS_NAME + i + ".growth: " + appCSVTable.get(i).growth);
            out.println(CLASS_NAME + i + ".weight: " + appCSVTable.get(i).weight);
            out.println(CLASS_NAME + i + ".weight: " + appCSVTable.get(i).weight);
            out.println(CLASS_NAME + i + ".agreement: " + appCSVTable.get(i).agreement);
            out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

    }

}
