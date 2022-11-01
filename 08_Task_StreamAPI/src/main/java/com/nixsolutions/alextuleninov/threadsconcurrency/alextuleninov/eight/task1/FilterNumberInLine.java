/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.eight.task1;

import java.util.Arrays;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * For lists of rows, filter out all numbers that are reduced in all rows,
 * and take them from the head of the next sum. For example:
 * The rows [“string 1 text”, “2 string 3 text”, “45”] gives the result 12345
 * Description: Character can use digit and isDigit, and String can use codepoints().
 */
public final class FilterNumberInLine {

    public static void main(String[] args) {

        FilterNumberInLine f = new FilterNumberInLine();
        f.filterNumberInLineToConsole(new String[]{"string 1 text", "2 string 3 text", "45"});
        out.println();

        f.filterNumberInLineToConsole(null);
        f.filterNumberInLineToConsole(new String[]{});
        out.println();

        f.filterNumberInLineToConsole1(new String[]{"string 1 text", "2 string 3 text", "45"});
        out.println();

        out.print(f.filterNumberInLineToString(new String[]{"string 1 text", "2 string 3 text", "45"}));
        out.print(f.filterNumberInLineToString(null));
        out.println();

        out.print(f.filterNumberInLineToOptionalLong(new String[]{"string 1 text", "2 string 3 text", "45"}));
        out.println();
        out.print(f.filterNumberInLineToOptionalLong(null));
        out.println();

        out.print(f.filterNumberInLineToLong(new String[]{"string 1 text", "2 string 3 text", "45"}));
        out.println();
        try {
            out.print(f.filterNumberInLineToLong(new String[]{}));
        } catch (IllegalArgumentException e) {
            err.println("Input contains no valid digits");
        }
        try {
            out.print(f.filterNumberInLineToLong(null));
        } catch (NullPointerException e) {
            err.println("Input null");
        }
    }

    /**
     * The method for lists of rows, filter out all numbers that are reduced in all rows,
     * * and take them from the head of the next sum
     *
     * @param string the array of rows
     */
    public void filterNumberInLineToConsole(String[] string) {
        if (string == null || string.length == 0) {
            err.println("Argument must be not null and length must be not 0");
            return;
        }

        String joinedString = String.join("", string);

        IntStream m = joinedString.codePoints()
                .filter(Character::isDigit)
                .map(s -> Character.digit(s, 10));
        m.forEach(out::print);
    }

    public void filterNumberInLineToConsole1(String[] string) {
        if (string == null || string.length == 0) {
            err.println("Argument must be not null and length must be not 0");
            return;
        }

        String joinedString = String.join("", string);

        joinedString.codePoints()
                .filter(Character::isDigit)
                .map(s -> Character.digit(s, 10)).forEach(out::print);
    }

    public String filterNumberInLineToString(String[] string) {
        if (string == null || string.length == 0) {
            err.println("Argument must be not null and length must be not 0");
            return "";
        }

        return Arrays.stream(string)
                .flatMap(s -> Stream.of(s.split("")))
                .filter(s -> Character.isDigit(s.charAt(0)))
                .reduce("", String::concat);
    }

    public OptionalLong filterNumberInLineToOptionalLong(String[] string) {
        if (string == null || string.length == 0) {
            return OptionalLong.empty();
        }
        return Arrays.stream(string)
                .flatMapToInt(String::codePoints)
                .filter(Character::isDigit)
                .map(s -> Character.digit(s, 10))
                .asLongStream()
                .reduce((number, s) -> number * 10 + s);
    }

    public long filterNumberInLineToLong(String[] string) {
        return Arrays.stream(string)
                .flatMapToInt(String::codePoints)
                .filter(Character::isDigit)
                .map(s -> Character.digit(s, 10))
                .asLongStream()
                .reduce((number, s) -> number * 10 + s)
                .orElseThrow(() -> new IllegalArgumentException("Input contains no valid digits: " + string));
    }

}
