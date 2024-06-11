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



//    具体来说，如果位于 (i,j) 的格子是战舰的头部，那么左边和上边的相邻格子不能是 X，即：
//
//    如果 j>0，那么 (i,j-1) 不能是 X。
//    如果 i>0，那么 (i−1,j) 不能是 X

    public int countBattleships(char[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' &&
                        (j == 0 || board[i][j - 1] != 'X') &&
                        (i == 0 || board[i - 1][j] != 'X')) {
                    ans++;
                }
            }
        }
        return ans;
    }


}