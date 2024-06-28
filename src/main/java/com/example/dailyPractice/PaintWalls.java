package com.example.dailyPractice;

import java.util.Arrays;

public class PaintWalls {



    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] memo = new int[n][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(n - 1, n, cost, time, memo);
    }

    // j 表示剩余需要的体积
    private int dfs(int i, int j, int[] cost, int[] time, int[][] memo) {
        if (j <= 0) { // 没有约束，后面什么也不用选了
            return 0;
        }
        if (i < 0) { // 此时 j>0，但没有物品可选，不合法
            return Integer.MAX_VALUE / 2; // 防止加法溢出
        }
        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j];
        }
        int res1 = dfs(i - 1, j - time[i] - 1, cost, time, memo) + cost[i];
        int res2 = dfs(i - 1, j, cost, time, memo);
        return memo[i][j] = Math.min(res1, res2);
    }


}
