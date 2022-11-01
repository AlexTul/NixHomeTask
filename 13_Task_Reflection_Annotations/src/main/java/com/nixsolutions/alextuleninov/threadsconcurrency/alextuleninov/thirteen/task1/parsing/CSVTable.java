package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.thirteen.task1.parsing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVTable {

    private final List<List<String>> csvTable;

    public CSVTable(List<List<String>> csvTable) {
        this.csvTable = csvTable;
    }

    public List<List<String>> getCsvTable() {
        return csvTable;
    }

    /**
     * To deny access to table elements by the row number is that column
     * (rows do not include headers).
     * Numbers start with 1.
     */
    public String searchByRowColumn(int row, int column) {
        return csvTable.get(row).get(column - 1);
    }

    /**
     * To deny access to table elements by the row number and the heading text.
     * Numbers start with 1.
     */
    public String searchByRowTitle(int row, String title) {
        List<String> titles = csvTable.get(0);
        Map<String, Integer> map = new HashMap();
        for (int i = 1; i <= titles.size(); i++) {
            map.put(csvTable.get(0).get(i - 1), i);
        }

        return csvTable.get(row).get(map.get(title));
    }

    /**
     * Select list of titles.
     */
    public List<String> getListHeaders() {
        return csvTable.get(0);
    }

}
