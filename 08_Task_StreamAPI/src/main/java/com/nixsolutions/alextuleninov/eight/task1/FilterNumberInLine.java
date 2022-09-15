/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.eight.task1;

import java.util.stream.IntStream;

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
        f.filterNumberInLine(new String[]{"string 1 text", "2 string 3 text", "45"});
        out.println();

        f.filterNumberInLine(null);
        out.println();

    }

    /**
     * The method for lists of rows, filter out all numbers that are reduced in all rows,
     * * and take them from the head of the next sum
     *
     * @param string the array of rows
     */
    public void filterNumberInLine(String[] string) {
        if (string == null) {
            out.print("Argument must be not null");
            return;
        }

        String joinedString = String.join("", string);

        IntStream m = joinedString.codePoints()
                .filter(Character::isDigit)
                .map(s -> Character.digit(s, 10));
        m.forEach(out::print);
    }

    public void filterNumberInLine1(String[] string) {
        if (string == null) {
            out.print("Argument must be not null");
            return;
        }

        String joinedString = String.join("", string);

        joinedString.codePoints()
                .filter(Character::isDigit)
                .map(s -> Character.digit(s, 10)).forEach(out::print);
    }

}
