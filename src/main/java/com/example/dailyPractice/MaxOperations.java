/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.LinkedList;

/**
 * MaxOperations
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-06-07 09:53
 */
public class MaxOperations {


    public static void main(String[] args) {
//        int[] nums = {3,2,1,4,5};
//        int[] nums = {3, 2, 6, 1, 4};

//        int[] nums = {3, 2};
        int[] nums = {3, 2, 1, 4};

        int res = maxOperations(nums);
        System.out.println(res);
    }

    // 3038 相同分数的最大操作数目1
    public static int maxOperations(int[] nums) {
        int res = 0;
        int index = 0;
        int sum = 0;
        LinkedList<Integer> quene = new LinkedList<Integer>();
        while (index < nums.length - 1) {
            if (index == 0) {
                sum = nums[index] + nums[index + 1];
                res++;
            } else {
                int tmpSum = nums[index] + nums[index + 1];
                if (tmpSum != sum) {
                    break;
                } else {
                    res++;
                }
            }
            index = index + 2;
        }
        return res;
    }


}