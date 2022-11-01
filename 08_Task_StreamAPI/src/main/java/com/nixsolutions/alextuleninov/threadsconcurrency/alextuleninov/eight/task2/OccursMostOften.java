package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.eight.task2;

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

    public BigDecimal findСommon1(List<BigDecimal> theList) {
        /**
         * Другое решение, собирая элементы на карте по их частоте, затем находить запись с максимальным значением
         * и возвращая ее ключ (в основном то же самое решение на arshajii answer, написанный с использованием Java 8):
         * */
        return theList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .map(Map.Entry::getKey).orElse(null);
    }

    public List<BigDecimal> findСommon2(List<BigDecimal> theList) {
        /**
         * Обновление: Если наиболее частые элементы более одного, и вы хотите получить их все в коллекции,
         * я предлагаю два метода:
         *
         * Метод A:. После сбора исходной коллекции на карту с ключами как элементами и значениями в качестве
         * их количества, получение записи с максимальным значением и фильтрация записей карты со значением,
         * равным этому максимальное значение (если) мы нашли. Что-то вроде этого:
         * */
        Map<BigDecimal, Long> elementCountMap = theList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

       return elementCountMap.values().stream()
                .max(Long::compareTo)
                .map(maxValue -> elementCountMap.entrySet().stream().filter(entry -> maxValue.equals(entry.getValue()))
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public List<BigDecimal> findСommon3(List<BigDecimal> theList) {
        /**
         * Метод B: После сбора исходной коллекции на карту с ключами как элементами и значениями в качестве
         * их количества, преобразование этой карты в новую карту с ключами как количество вхождений,
         * значения как список элементов с таким количеством вхождений. А затем нахождение максимального элемента
         * этой карты с помощью специального компаратора, который сравнивает ключи и получает значение этой записи.
         * Вот так:
         * */

        return theList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .max((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList());
    }

}
