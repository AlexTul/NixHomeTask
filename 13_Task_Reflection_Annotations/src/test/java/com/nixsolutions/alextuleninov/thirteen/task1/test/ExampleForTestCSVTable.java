package com.nixsolutions.alextuleninov.thirteen.task1.test;

import java.util.ArrayList;
import java.util.List;

public class ExampleForTestCSVTable {

    public static List<List<String>> run() {

        return getCSVTable(getHeads(), getRow1(), getRow2(), getRow3());

    }

    public static List<List<String>> getCSVTable(
            List<String> heads, List<String> row1,
            List<String> row2, List<String> row3) {

        List<List<String>> csvTable = new ArrayList<>();
        csvTable.add(heads);
        csvTable.add(row1);
        csvTable.add(row2);
        csvTable.add(row3);

        return csvTable;
    }

    public static List<String> getRow3() {

        List<String> row3 = new ArrayList<>();
        row3.add("Lisa");
        row3.add("FEMALE");
        row3.add("19");
        row3.add("170");
        row3.add("53.2");
        row3.add("true");

        return row3;
    }

    public static List<String> getRow2() {

        List<String> row2 = new ArrayList<>();
        row2.add("Piter");
        row2.add("MALE");
        row2.add("22");
        row2.add("182");
        row2.add("98.5");
        row2.add("false");

        return row2;
    }

    public static List<String> getRow1() {

        List<String> row1 = new ArrayList<>();
        row1.add("Jorg");
        row1.add("MALE");
        row1.add("21");
        row1.add("180");
        row1.add("96.5");
        row1.add("true");

        return row1;
    }

    public static List<String> getHeads() {

        List<String> heads = new ArrayList<>();
        heads.add("name");
        heads.add("sex");
        heads.add("age");
        heads.add("growth");
        heads.add("weight");
        heads.add("agreement");

        return heads;
    }

}
