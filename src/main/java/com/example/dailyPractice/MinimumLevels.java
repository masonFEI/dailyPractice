/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.Arrays;

/**
 * MinimumLevels
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-07-19 13:25
 */
public class MinimumLevels {


    public static void main(String[] args) {

//        int[] possible = {1, 0, 1, 0};
//        int[] possible = {1, 1, 1, 1, 1};
        int[] possible = {0, 0};

        int res = minimumLevels(possible);
        System.out.println(res);

    }


    public static int minimumLevels(int[] possible) {
        int sum = Arrays.stream(possible).sum();
        int aScore = 0;
        int aSum = 0;
        int bScore = 0;
        int index = -1;

        for (int i = 0; i < possible.length - 1; i++) {
            aSum += possible[i];
            aScore = 2 * aSum - i - 1;
            int bSum = sum - aSum;
            bScore = 2 * bSum - possible.length + i + 1;


            if (aScore > bScore && index == -1) {
                index = i + 1;
            }
        }

        return index;
    }


}