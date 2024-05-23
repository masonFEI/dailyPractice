/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LongestEqualSubarray
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-05-23 15:38
 */
public class LongestEqualSubarray {


//    测试用例:[9,5,1,4,2,3,4,13,5,2,7,2,2,14]
//            4
//    测试结果:2
//    期望结果:3

    public static void main(String[] args) {
        int[] intArray = {9, 5, 1, 4, 2, 3, 4, 13, 5, 2, 7, 2, 2, 14};
//        int[] intArray = {3,1,5,3,1,1};
//        int[] intArray = {1};
//        int[] intArray = {3,4,3,5,3,6,3,8,3,8,3,8,8};
//        int[] intArray = {1, 3, 2, 3, 1, 3};
//        int[] intArray = {1, 1, 2, 2, 1, 1};
        List<Integer> nums = IntStream.of(intArray).boxed().collect(Collectors.toList());
//        int k = 2;
//        int k = 0;
        int k = 4;
        int res = longestEqualSubarray(nums, k);
        System.out.println(res);
    }


//    输入：nums = [1,1,2,2,1,1], k = 2 输出：4

//    输入：nums = [1,3,2,3,1,3], k = 3

//    输入：nums = [3,4,3,5,3,6,3,8,3,8,3,8,8], k = 2 输出：4


    public static int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        for (List<Integer> vec : pos.values()) {
            for (int i = 0, j = 0; i < vec.size(); i++) { /* 缩小窗口，直到不同元素数量小于等于 k */
                while (vec.get(i) - vec.get(j) - (i - j) > k) {
                    j++;
                }
                ans = Math.max(ans, i - j + 1);
            }
        }
        return ans;

    }


}