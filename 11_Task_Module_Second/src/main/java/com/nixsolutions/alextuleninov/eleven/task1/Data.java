/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.eleven.task1;

import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * The Data class provides getting initial data from the user.
 */
public final class Data {

    private static final Scanner scanner = new Scanner(System.in);

    public static Path getDataPath() {
        Path path = null;
        try  {
            out.print("Please, enter the path to a file: ");
            // C:\Users\Дом\IdeaProjects\NixHomeTask\11_Task_Module_Second\src\main\resources\task.txt
            path = Path.of(scanner.nextLine());
        } catch (NoSuchElementException e) {
            err.print("No line was found");
        }

        return path;
    }

    public static int[] getDataCoordinates() {
        int[] coordinates = new int[4];
        try {
            out.print("\nPlease, enter the coordinates (format: \"x y\") of the ENTRANCE from the maze, " +
                    "which should correspond to two of the passing cells: ");
            coordinates[0] = scanner.nextInt();
            coordinates[1] = scanner.nextInt();
            out.print("\nPlease, enter the coordinates (format: \"x y\") of the EXIT from the maze, " +
                    "which should correspond to two of the passing cells: ");
            coordinates[2] = scanner.nextInt();
            coordinates[3] = scanner.nextInt();
            scanner.close();
        } catch (InputMismatchException e) {
            err.print("The next token does not match the Integer regular expression, or is out of range");
        }

        return coordinates;
    }

}
