/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.eleven.task1;

import java.util.*;

import static java.lang.System.err;

/**
 * The Algorithm class represents algorithm for solving the problem
 * of finding the shortest path from input to output.
 */
public final class Algorithm {

    private static char[][] matrix;

    char[][] getMat() {
        return matrix;
    }

    boolean booleanResultPath(char[][] mat, int x1, int y1, int x2, int y2) {

        HashMap<Node, Node> returnPath = new HashMap<>();

        boolean shortPath = findShortestPath(mat, x1, y1, x2, y2, returnPath);

        if (shortPath) {
            List<Node> points = new ArrayList<>();
            Node point = returnPath.get(new Node(x2, y2));

            points.add(new Node(x2, y2));

            while (point != null) {
                points.add(point);
                point = returnPath.get(point);
            }

            points.forEach(current -> mat[current.x()][current.y()] = '#');

            matrix = mat;

            return true;
        }
        return false;
    }

    private static boolean findShortestPath(char[][] mat, int x1, int y1, int x2, int y2, Map<Node, Node> returnPath) {

        if (mat[x1][y1] == 0 || mat[x2][y2] == 0) {
            err.print("Incorrect file");
            return false;
        }

        int[] row = {-1, 0, 0, 1};
        int[] col = {0, -1, 1, 0};

        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<Node> q = new ArrayDeque<>();

        visited[x1][y1] = true;
        q.add(new Node(x1, y1));
        returnPath.put(new Node(x1, y1), null);

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.x() == x2 && node.y() == y2) {
                return true;
            }

            for (int k = 0; k < 4; k++) {
                if (isValid(mat, visited, node.x() + row[k], node.y() + col[k])) {
                    visited[node.x() + row[k]][node.y() + col[k]] = true;
                    q.add(new Node(node.x() + row[k], node.y() + col[k]));
                    returnPath.put(new Node(node.x() + row[k], node.y() + col[k]), node);
                }
            }
        }
        return false;
    }

    private static boolean isValid(char[][] mat, boolean[][] visited, int row, int col) {
        return (row >= 0) && (row < mat.length) && (col >= 0) && (col < mat[0].length)
                && mat[row][col] == '+' && !visited[row][col];
    }

}
