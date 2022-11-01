/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.eleven.task1;

import java.nio.file.Path;

import static java.lang.System.*;

/**
 * The user enters the path to the text file. This is a "labyrinth", where '+' is a corridor and '-' is a wall.
 * The size of the "map" can be unlimited, but it will always have the shape of a rectangle.
 * Also, the user enters the coordinates (x, y) of the entrance and exit from the maze,
 * which must correspond to two of the "passing" cells. Task: find (one of) the shortest path from the input
 * to the output, if it exists, and output it to the console.
 * If there is no path, display the corresponding message.
 */
public final class ShortestRouteFromEntranceToExit {

    public static void main(String[] args) {

        Data data = new Data();

        Path path = data.getDataPath();
        int[] coordinates = data.getDataCoordinates();

        char[][] matrix = new Matrix().readAllLinesToMatrix(path);

        boolean resultProgramm = new Algorithm()
                .booleanResultPath(matrix, coordinates[0], coordinates[1], coordinates[2], coordinates[3]);

        if (resultProgramm) {
            new PrintedResult().printedResult(new Algorithm().getMat());
        } else {
            out.println("There is no way");
        }
    }

}
