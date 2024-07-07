package com.example.dailyPractice;

public class CheckMove {





    private static final int[][] DIRS = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int m = board.length;
        int n = board[0].length;
        for (int[] dir : DIRS) {
            int x = rMove + dir[0];
            int y = cMove + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != (color ^ 'B' ^ 'W')) {
                continue;
            }
            while (true) {
                x += dir[0];
                y += dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] == '.') {
                    break;
                }
                if (board[x][y] == color) {
                    return true;
                }
            }
        }
        return false;
    }


}
