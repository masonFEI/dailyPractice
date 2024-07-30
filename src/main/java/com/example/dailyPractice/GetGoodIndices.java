/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.ArrayList;
import java.util.List;

/**
 * GetGoodIndices
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-07-30 18:58
 */
public class GetGoodIndices {


    public static void main(String[] args) {

//        int[][] variables = {{2,3,3,10},{3,3,3,1},{6,1,1,4}};
//        int target = 2;

        int[][]  variables = {{39,3,1000,1000}};
        int target = 17;

        List<Integer> res = getGoodIndices(variables, target);
        System.out.println(res);
    }



    public static List<Integer> getGoodIndices(int[][] variables, int target) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            double value = Math.pow(Math.pow(variables[i][0], variables[i][1]) % 10, variables[i][2]) % variables[i][3];
            if (value == target) {
                res.add(i);
            }

        }

        return res;

    }


}