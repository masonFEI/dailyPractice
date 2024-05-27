/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.Arrays;

/**
 * MissingRolls
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-05-27 19:59
 */
public class MissingRolls {


    public static void main(String[] args) {
//        int[] rolls = {3,2,4,3};
//        int mean = 4;
//        int n = 2;
//        int[] rolls = {1,5,6};
//        int mean = 3;
//        int n = 4;

//        int[] rolls = {1,2,3,4};
//        int mean = 6;
//        int n = 4;
        int[] rolls = {6, 3, 4, 3, 5, 3};
        int mean = 1;
        int n = 6;
        int[] res = missingRolls(rolls, mean, n);

        System.out.println(res);
    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = mean * (rolls.length + n);
        int rollSum = Arrays.stream(rolls).sum();
        int diff = sum - rollSum;
        if (diff < n || diff > 6 * n) {
            return new int[0];
        }

        int aizx = diff / n;
        int remainder = diff % n;
        int[] result = new int[n];

        if (remainder > 0) {
            int addOneNum = diff - aizx * n;
            for (int i = 0; i < n; i++) {
                if (i < addOneNum) {
                    result[i] = aizx + 1;
                } else {
                    result[i] = aizx;
                }
            }
        } else {
            Arrays.fill(result, aizx);
        }

        return result;

    }


}