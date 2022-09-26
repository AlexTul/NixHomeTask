package com.nixsolutions.alextuleninov.thirteen.task1.test.parsing;

import com.nixsolutions.alextuleninov.thirteen.task1.parsing.CSVTable;
import com.nixsolutions.alextuleninov.thirteen.task1.test.ExampleForTestCSVTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CSVTableTest {

    @Test
    void testSearchByRowColumn() {

        var table = new CSVTable(ExampleForTestCSVTable.run());

        assertEquals(ExampleForTestCSVTable.getRow1().get(0), table.searchByRowColumn(1,1));
        assertEquals(ExampleForTestCSVTable.getRow2().get(1), table.searchByRowColumn(2,2));
        assertEquals(ExampleForTestCSVTable.getRow3().get(2), table.searchByRowColumn(3,3));

    }

    @Test
    void testSearchByRowTitle() {

        var table = new CSVTable(ExampleForTestCSVTable.run());

        assertEquals(ExampleForTestCSVTable.getRow1().get(1), table.searchByRowTitle(1, "name"));
        assertEquals(ExampleForTestCSVTable.getRow2().get(2), table.searchByRowTitle(2, "sex"));
        assertEquals(ExampleForTestCSVTable.getRow3().get(3), table.searchByRowTitle(3, "age"));

    }

    @Test
    void testGetListHeaders() {

        var table = new CSVTable(ExampleForTestCSVTable.run());

        assertEquals(ExampleForTestCSVTable.getHeads(), table.getListHeaders());

    }

}
