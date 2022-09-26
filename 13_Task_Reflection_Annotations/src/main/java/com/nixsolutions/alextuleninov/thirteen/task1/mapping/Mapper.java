package com.nixsolutions.alextuleninov.thirteen.task1.mapping;

import com.nixsolutions.alextuleninov.thirteen.task1.parsing.CSVTable;

import java.util.List;

public interface Mapper {

    <T> List<T> map(CSVTable table, Class<T> resultType);

}
