/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

/**
 * MaxScore
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-06-14 11:09
 */
public class MaxScore {

    public static void main(String[] args) {
//[2,3,6,1,9,2]
//        5

//        int[] nums = {2, 3, 6, 1, 9, 2};
//        int x = 5;

        int[] nums = {38,92,23,30,25,96,6,71,78,77,33,23,71,48,87,77,53,28,6,20,90,83,42,21,64,95,84,29,22,21,33,36,53,51,85,25,80,56,71,69,5,21,4,84,28,16,65,7};

        int x = 52;
        long res = maxScore(nums, x);
        System.out.println(res);
    }

    public static long maxScore(int[] nums, int x) {

        int[][] dp = new int[nums.length][4];
        // 加当前值的余数
        dp[0][0] = nums[0] % 2;
        // 加当前值的和
        dp[0][1] = nums[0];
        // 不加当前值的余数
        dp[0][2] = nums[0] % 2;
        // 不加当前值的和
        dp[0][3] = nums[0];

        // 加当前值的余数
        dp[1][0] = nums[1] % 2;
        int tmpSum1 = nums[0];
        if (dp[1][0] != dp[0][0]) {
            tmpSum1 += nums[1] - x;
        } else {
            tmpSum1 += nums[1];
        }

        // 和
        dp[1][1] = tmpSum1;
        // 不加当前值 的 余数
        dp[1][2] = nums[0] % 2;
        // 不加当前值 的 余数
        dp[1][3] = nums[0];

        for (int i = 2; i < nums.length; i++) {
            int yuItem = nums[i] % 2;
            // 加前一个数后的余数
            int preYu1 = dp[i - 1][0];
            // 加前一个数后的和
            int tmpSumPre1 = dp[i - 1][1];
            // 不加前一个数后的余数
            int preYu2 = dp[i - 1][2];
            // 不加前一个数后的和
            int tmpSumPre2 = dp[i - 1][3];

            if (yuItem != preYu1) {
                tmpSumPre1 += nums[i] - x;
            } else {
                tmpSumPre1 += nums[i];
            }

            if (yuItem != preYu2) {
                tmpSumPre2 += nums[i] - x;
            } else {
                tmpSumPre2 += nums[i];
            }
            dp[i][0] = yuItem;
            dp[i][1] = Math.max(tmpSumPre1, tmpSumPre2);

            // 不加当前数
            dp[i][2] = dp[i - 1][1] > dp[i - 1][3] ? dp[i - 1][0] : dp[i - 1][2];
            dp[i][3] = Math.max(dp[i - 1][1], dp[i - 1][3]);
        }

        return Math.max(dp[nums.length - 1][1], dp[nums.length - 1][3]);
    }

}