//package com.nixsolutions.alextuleninov.eleven.task1;
//
//import java.util.ArrayDeque;
//import java.util.Queue;
//
//public class MAin {
//
//    // Below arrays detail all four possible movements from a cell
//    // В приведенных ниже массивах подробно описаны все четыре возможных движения из ячейки.
//    private static final int[] row = { -1, 0, 0, 1 }; // строка Top Down
//    private static final int[] col = { 0, -1, 1, 0 }; // столбец Left Right
//    /*
//        Go Top (наверх): (x, y) ——> (x – 1, y)
//        Go Left (влево): (x, y) ——> (x, y – 1)
//        Go Down (вниз): (x, y) ——> (x + 1, y)
//        Go Right (вправо): (x, y) ——> (x, y + 1)
//    * */
//
//    // Function to check if it is possible to go to position (row, col)
//    // from the current position. The function returns false if (row, col)
//    // is not a valid position or has a value 0 or already visited.
//    /* Функция проверки возможности перехода на позицию (строка, столбец)
//     * от текущего положения. Функция возвращает false, если (строка, столбец)
//     * недопустимая позиция или имеет значение 0 или уже посещено.
//     * */
//    private static boolean isValid(int[][] mat, boolean[][] visited, int row, int col) {
//        return (row >= 0) && (row < mat.length)
//                && (col >= 0) && (col < mat[0].length)
//                && mat[row][col] == 1 && !visited[row][col];
//    }
//
//    // Find the shortest possible route in a matrix `mat` from source
//    // cell (i, j) to destination cell (x, y)
//    /*
//    * Найдите кратчайший путь в матрице `mat` из источника
//    * ячейка (i, j) в ячейку назначения (x, y)
//    * */
//    private static int findShortestPathLength(int[][] mat, int i, int j, int x, int y) {
//        // base case: invalid input
//        // базовый случай: неверный ввод
//        if (mat == null || mat.length == 0 || mat[i][j] == 0 || mat[x][y] == 0) {
//            return -1;
//        }
//
//        // `M × N` matrix
//        int M = mat.length;
//        int N = mat[0].length;
//
//        // construct a matrix to keep track of visited cells
//        // построить матрицу для отслеживания посещенных ячеек
//        boolean[][] visited = new boolean[M][N];
//
//        // create an empty queue
//        // создать пустую очередь
//        Queue<Node> q = new ArrayDeque<>();
//
//        // mark the source cell as visited and enqueue the source node
//        // пометить исходную ячейку как посещенную и поставить исходный узел в очередь
//        visited[i][j] = true;
//        q.add(new Node(i, j, 0));
//
//        // stores length of the longest path from source to destination
//        // сохраняет длину самого длинного пути от источника к месту назначения
//        int min_dist = Integer.MAX_VALUE;
//
//        // loop till queue is empty
//        // цикл до тех пор, пока очередь не станет пустой
//        while (!q.isEmpty()) {
//            // dequeue front node and process it
//            // удалить передний узел из очереди и обработать его
//            Node node = q.poll();
//
//            // (i, j) represents a current cell, and `dist` stores its
//            // minimum distance from the source
//            /*
//            * (i, j) представляет текущую ячейку, а `dist` хранит ее
//            * минимальное расстояние от источника
//            * */
//            i = node.x;
//            j = node.y;
//            int dist = node.dist;
//
//            // if the destination is found, update `min_dist` and stop
//            // если место назначения найдено, обновить `min_dist` и остановить
//            if (i == x && j == y) {
//                min_dist = dist;
//                break;
//            }
//
//            // check for all four possible movements from the current cell
//            // and enqueue each valid movement
//            /*
//            * проверить все четыре возможных перемещения из текущей ячейки
//            * и поставить в очередь каждое допустимое движение
//            * */
//            for (int k = 0; k < 4; k++) {
//                // check if it is possible to go to position
//                // (i + row[k], j + col[k]) from current position
//                /*
//                * проверить, можно ли выйти на позицию
//                * (i + row[k], j + col[k]) от текущей позиции
//                * */
//                if (isValid(mat, visited, i + row[k], j + col[k])) {
//                    // mark next cell as visited and enqueue it
//                    // пометить следующую ячейку как посещенную и поставить ее в очередь
//                    visited[i + row[k]][j + col[k]] = true;
//                    q.add(new Node(i + row[k], j + col[k], dist + 1));
//                }
//            }
//        }
//
//        if (min_dist != Integer.MAX_VALUE) {
//            return min_dist;
//        }
//        return -1;
//    }
//
//    public static void main(String[] args) {
//        int[][] mat = {
//                        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
//                        { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
//                        { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
//                        { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
//                        { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
//                        { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
//                        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
//                        { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
//                        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
//                        { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
//                };
//
//        int min_dist = findShortestPathLength(mat, 0, 0, 7, 5);
//
//        if (min_dist != -1) {
//            System.out.println("The shortest path from source to destination " +
//                    "has length " + min_dist);
//        } else {
//            System.out.println("Destination cannot be reached from source");
//        }
//    }
//}
