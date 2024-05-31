/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.HashMap;
import java.util.Map;

/**
 * FindMissingAndRepeatedValues
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-05-31 10:04
 */
public class FindMissingAndRepeatedValues {


    public static void main(String[] args) {
//        int[][] grid = {{1,3},{2,2}};
        int[][] grid = {{9,1,7},{8,9,2},{3,4,6}};

        int[] res = findMissingAndRepeatedValues(grid);
        System.out.println(res);
    }


    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] res = new int[2];
        int max = (grid.length) * (grid.length);
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int sum = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < grid.length; j++) {
                if (map.containsKey(ints[j])) {
                    left = ints[j];
                } else {
                    map.put(ints[j], 1);
                    sum += ints[j];
                }
            }
        }

        int midValue = 0;
        if (max % 2 == 1) {
            midValue = (1 + max) / 2;
        }

        int right = (1 + max) * (max / 2) + midValue - sum;
        res[0] = left;
        res[1] = right;
        return res;
    }


}