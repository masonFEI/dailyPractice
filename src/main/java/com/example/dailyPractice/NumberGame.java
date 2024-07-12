/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.Arrays;

/**
 * NumberGame
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-07-12 14:46
 */
public class NumberGame {


    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 3};
        int[] ints = numberGame(nums);
        System.out.println(ints); // [3, 2, 5, 4]
    }


//    输入：nums = [5,4,2,3] 输出：[3,2,5,4]

    public static int[] numberGame(int[] nums) {

        int[] res = new int[nums.length];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i = i + 2) {
            int a = nums[i];
            int b = nums[i + 1];
            res[i] = b;
            res[i + 1] = a;
        }
        return res;

    }

}