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
        int[] intArray = {3,1,5,3,1,1};
//        int[] intArray = {1};
//        int[] intArray = {3,4,3,5,3,6,3,8,3,8,3,8,8};
//        int[] intArray = {1, 3, 2, 3, 1, 3};
//        int[] intArray = {1, 1, 2, 2, 1, 1};
        List<Integer> nums = IntStream.of(intArray).boxed().collect(Collectors.toList());
//        int k = 2;
        int k = 0;
        int res = longestEqualSubarray(nums, k);
        System.out.println(res);
    }


//    输入：nums = [1,1,2,2,1,1], k = 2 输出：4

//    输入：nums = [1,3,2,3,1,3], k = 3

//    输入：nums = [3,4,3,5,3,6,3,8,3,8,3,8,8], k = 2 输出：4


    public static int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, LinkedList<Integer>> numsItemRangeMap = new HashMap<>();

        // 统计下不同的数字在数组中出现的位置
        for (int i = 0; i < nums.size(); i++) {
            Integer number = nums.get(i);
            LinkedList<Integer> indexList = new LinkedList<>();
            if (numsItemRangeMap.containsKey(number)) {
                indexList = numsItemRangeMap.get(number);
            }
            indexList.add(i);
            numsItemRangeMap.put(number, indexList);
        }
        // 对map中存在重复数字的数组，双指针计算其下标之间的距离
        Map<Integer, Integer> numColledMap = new HashMap<>();
        int maxColledNum = nums.isEmpty() ? 0 : 1;

        for (Map.Entry<Integer, LinkedList<Integer>> entry : numsItemRangeMap.entrySet()) {
            Integer numberkey = entry.getKey();
            LinkedList<Integer> indexList = entry.getValue();
            if (indexList.size() > 1) {
                int left = 0;
                int right = 1;
                int cost = 0;
                int colledNum = 1;
                numColledMap.put(numberkey, colledNum);
                while (right < indexList.size()) {
                    cost += indexList.get(right) - indexList.get(left) - 1;

                    if (cost > k) {
                        left = right;
                        right++;
                        if (colledNum > numColledMap.get(numberkey)) {
                            numColledMap.put(numberkey, colledNum);
                        }
                        colledNum = 0;
                        cost = 0;
                    } else {
                        left++;
                        right++;
                    }

                    colledNum++;

                    if (right == indexList.size()) {
                        if (colledNum > numColledMap.get(numberkey)) {
                            numColledMap.put(numberkey, colledNum);
                        }
                    }

                }

                if (numColledMap.get(numberkey) > maxColledNum) {
                    maxColledNum = numColledMap.get(numberkey);
                }
            }
        }
        return maxColledNum;

    }


}