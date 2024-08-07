package com.example.dailyPractice;

public class NumTrees {


    public static void main(String[] args) {


    }

    public int numTrees(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        if (n == 1) {
            return dp[n];
        }
        dp[2] = 2;
        if (n == 2) {
            return dp[n];
        }

        for (int i = 3; i < n + 1; i++) {

            dp[i] = 0;
            for (int j = i - 1; j >= 0; j--) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];

    }


}
