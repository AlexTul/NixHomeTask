package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.eleven.task1;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * The Matrix class create a matrix.
 * */
public final class Matrix {

    public char[][] readAllLinesToMatrix(Path path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException("Incorrect path", e);
        }

        int matrixSize = lines.size();
        char[][] matrix = new char[lines.size()][lines.size()];

        for (int i = 0; i < matrixSize; i++) {
            char[] line = lines.get(i).toCharArray();
            System.arraycopy(line, 0, matrix[i], 0, lines.size());
        }

        return matrix;
    }

}
