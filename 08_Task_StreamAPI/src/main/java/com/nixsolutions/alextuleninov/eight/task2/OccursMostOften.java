package com.nixsolutions.alextuleninov.eight.task2;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * For a list of numbers (List<BigDecimal>), rotate those that are the most compressed.
 * */
public final class OccursMostOften {

    public static void main(String[] args) {

        List<BigDecimal> theList = new ArrayList<>();
        theList.add(BigDecimal.valueOf(1));
        theList.add(BigDecimal.valueOf(1));
        theList.add(BigDecimal.valueOf(2));
        theList.add(BigDecimal.valueOf(3));
        theList.add(BigDecimal.valueOf(4));
        theList.add(BigDecimal.valueOf(5));

        List<BigDecimal> theListNull = new ArrayList<>();

        OccursMostOften common = new OccursMostOften();
        System.out.println(common.findСommon(theList));
        System.out.println(common.findСommon(theListNull));

    }

    /**
     * The method for a list of numbers (List<BigDecimal>), rotate those that are the most compressed.
     *
     * @param theList       the list with data
     * */
    public BigDecimal findСommon(List<BigDecimal> theList) {
        return theList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .map(Map.Entry::getKey).orElse(null);
    }

}
