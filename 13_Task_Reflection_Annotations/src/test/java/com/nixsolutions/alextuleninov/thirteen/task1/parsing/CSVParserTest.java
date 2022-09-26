package com.nixsolutions.alextuleninov.thirteen.task1.parsing;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVParserTest {

    private static List<String> heads;
    private static List<String> row1;
    private static List<String> row2;
    private static List<String> row3;
    private static List<List<String>> csvTable;

    @BeforeAll
    public static void init() {
        heads = new ArrayList<>();
        heads.add("name");
        heads.add("sex");
        heads.add("age");
        heads.add("growth");
        heads.add("weight");
        heads.add("agreement");

        row1 = new ArrayList<>();
        row1.add("Jorg");
        row1.add("Male");
        row1.add("21");
        row1.add("180");
        row1.add("96.5");
        row1.add("true");

        row2 = new ArrayList<>();
        row2.add("Piter");
        row2.add("Male");
        row2.add("22");
        row2.add("182");
        row2.add("98.5");
        row2.add("false");

        row3 = new ArrayList<>();
        row3.add("Lisa");
        row3.add("Female");
        row3.add("19");
        row3.add("170");
        row3.add("53.2");
        row3.add("true");

        csvTable = new ArrayList<>();
        csvTable.add(heads);
        csvTable.add(row1);
        csvTable.add(row2);
        csvTable.add(row3);
    }

    @AfterAll
    public static void clean() {
        heads = null;
        row1 = null;
        row2 = null;
        row3 = null;
        csvTable = null;
    }

    @Test
    void parse() {

        var parser = new CSVParser();

        Path path = Path.of(
                "C:\\Users\\Дом\\IdeaProjects\\NixHomeTask\\13_Task_Reflection_Annotations\\example\\magazine.csv");

        CSVTable table = parser.parse(path);
        List<List<String>> actual = table.getCsvTable();

        assertEquals(csvTable, actual);

    }

}