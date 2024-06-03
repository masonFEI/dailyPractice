/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

/**
 * DistributeCandiesIII
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-06-03 13:28
 */
public class DistributeCandiesIII {


    public static void main(String[] args) {

//        int candies = 10;
//        int num_people = 3;
        int candies = 7;
        int num_people = 4;
        int[] res = distributeCandies(candies, num_people);
        System.out.println(res);

    }


    public static int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];

        int sum = 0;
        // 分的次数
        int i = 1;

        while (true) {
            if (sum + i > candies) {
                break;
            }
            sum += i;
            i++;
        }

        int last = candies - sum;
        int index = 1;
        while (index <= i) {
            int yu = index % num_people;
            int arrayIndex = yu - 1;
            if (yu == 0) {
                arrayIndex = num_people - 1;
            }

            if (index == i) {
                res[arrayIndex] += last;
            } else {
                res[arrayIndex] += index;
            }
            index++;
        }

        return res;

    }

}