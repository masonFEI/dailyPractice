/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.math.BigDecimal;
import java.math.MathContext;
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

//        int[][]  variables = {{39,3,1000,1000}};
//        int target = 17;

        int[][] variables = {{31, 12, 21, 24}};
        int target = 1;

        List<Integer> res = getGoodIndices(variables, target);
        System.out.println(res);
    }


    public static List<Integer> getGoodIndices(int[][] variables, int target) {

        List<Integer> res = new ArrayList<>();
        MathContext mc = new MathContext(0);
        for (int i = 0; i < variables.length; i++) {
            int[] variable = variables[i];
            BigDecimal base = new BigDecimal(variable[0]);
            BigDecimal exponent = new BigDecimal(variable[1]);
            // 使用 BigDecimal 的 pow 方法计算幂次方
            BigDecimal result = base.pow(exponent.intValueExact(), mc);
            BigDecimal divisor = new BigDecimal("10"); // 你的除数
            BigDecimal base1 = result.remainder(divisor);
            BigDecimal exponent1 = new BigDecimal(variable[2]);
            BigDecimal result1 = base1.pow(exponent1.intValueExact(), mc);

            BigDecimal divisor1 = new BigDecimal(variable[3]); // 你的除数
            BigDecimal finalRes = result1.remainder(divisor1);

            if (finalRes.compareTo(new BigDecimal(target)) == 0) {
                res.add(i);
            }
        }

        return res;

    }


}