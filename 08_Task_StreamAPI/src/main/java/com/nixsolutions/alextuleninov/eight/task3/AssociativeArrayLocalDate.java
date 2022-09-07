/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.eight.task3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import static java.lang.System.out;

/**
 * For lists of LocalDateTime parameters, the associative array LocalDate -> List<LocalTime> is rotated,
 * grouping query/hour by date. Save to card sort by date order.
 * */
public class AssociativeArrayLocalDate {

    public static void main(String[] args) {

        List<LocalDateTime> list = Arrays.asList(
                LocalDateTime.of(2016, 9, 19, 14, 5, 20),
                LocalDateTime.of(2015, 4, 17, 18, 10, 20),
                LocalDateTime.of(2013, 4, 17, 18, 10, 20));

        List<LocalDateTime> listNull = null;

        AssociativeArrayLocalDate aALD = new AssociativeArrayLocalDate();
        out.println(aALD.findAssociativeArrayLocalDate(list));
        out.println(aALD.findAssociativeArrayLocalDate(listNull));

    }

    /**
     * A method that will rotate the LocalDate -> List<LocalTime> associative array for lists
     * of LocalDateTime parameters, grouping query/hour by date. Save to card sort by date order.
     *
     * @param list      the collection List<LocalTime>
     * */
    public Map<LocalDate, List<LocalDateTime>> findAssociativeArrayLocalDate(List<LocalDateTime> list) {
        if (list == null) {
            return Collections.emptyMap();
        }

        return list.stream()
                .collect(Collectors.groupingBy(LocalDateTime::toLocalDate, TreeMap::new, Collectors.toList()));
    }

}