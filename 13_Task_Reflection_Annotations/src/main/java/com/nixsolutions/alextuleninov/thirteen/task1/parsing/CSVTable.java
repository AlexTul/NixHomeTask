package com.nixsolutions.alextuleninov.thirteen.task1.parsing;

import java.util.List;

public final class CSVTable {

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
        int index = 0;
        for (int i = 0; i < titles.size(); i++) {
            if (titles.get(i).equals(title)) {
                index = i;
            }
        }

        return csvTable.get(row).get(index + 1);
    }

    /**
     * Select list of titles.
     */
    public List<String> getListHeaders() {
        return csvTable.get(0);
    }

}
