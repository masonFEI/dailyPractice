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

        int[] nums = {38, 92, 23, 30, 25, 96, 6, 71, 78, 77, 33, 23, 71, 48, 87, 77, 53, 28, 6, 20, 90, 83, 42, 21, 64, 95, 84, 29, 22, 21, 33, 36, 53, 51, 85, 25, 80, 56, 71, 69, 5, 21, 4, 84, 28, 16, 65, 7};

        int x = 52;
        long res = maxScore(nums, x);
        System.out.println(res);
    }

    public static long maxScore(int[] nums, int x) {
        long res = 0;
        long[] dp = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        dp[nums[0] % 2] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int yu = nums[i] % 2;
            long maxValue = Math.max(dp[yu] + nums[i], dp[1 - yu] + nums[i] - x);
            res = Math.max(res, maxValue);
            dp[yu] = Math.max(dp[yu], maxValue);
        }

        return res;

    }

}