/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

/**
 * CountBattleships
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-06-11 09:51
 */
public class CountBattleships {


    public static int shipCount;

    // 查找连续的方向为右，下，左，上
    public int countBattleships(char[][] board) {

        shipCount = 0;
        int[][] memo = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

            }
        }

        return shipCount;
    }


    public void deepSearch(int i, int j, int direction, int[][] memo, char[][] board) {
        if (memo[i][j] != 0) {
            return;
        }

        // 是X，则往同一个方向搜索
        if (String.valueOf(board[i][j]).equals("X")) {
            memo[i][j] = 1;
            // 向右
            if (direction == 0 && i + 1 < board[0].length) {

            } else if (direction == 1 && j + 1 < board.length) {
                // 向下
            } else if (direction == 2 && i - 1 >= 0) {
                // 向左
            } else if (direction == 2 && j - 1 >= 0) {
                // 向上
            }

        }


    }


}