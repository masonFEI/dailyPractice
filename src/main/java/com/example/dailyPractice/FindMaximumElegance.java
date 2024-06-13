/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.*;

/**
 * FindMaximumElegance
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-06-13 15:27
 */
public class FindMaximumElegance {


    public static void main(String[] args) {

        int[][] items = {{3, 2}, {5, 1}, {10, 1}};
        int k = 2;
        long res = findMaximumElegance(items, k);

        System.out.println(res);

    }


    public static long findMaximumElegance(int[][] items, int k) {
        long res = 0;
        long totalProfit = 0;
        Arrays.sort(items, (int[] o1, int[] o2) -> Integer.compare(o2[0], o1[0]));
        Set<Integer> categorySet = new HashSet<>();
        Deque<Integer> profitDeque = new ArrayDeque<>();
        for (int i = 0; i < items.length; i++) {
            int profit = items[i][0];
            int category = items[i][1];

            if (i < k) {
                // 在k个数量限制内，从大到小将值都加到总利润中
                totalProfit += profit;
                // 重复类型，以及重复类型的利润，从大到小
                if (!categorySet.add(category)) {
                    profitDeque.push(profit);
                }
            } else if (!profitDeque.isEmpty() && categorySet.add(category)) {
                // 超出k个数量限制，并且重复类型的利润队列不为空，则进行利润调整
                Integer minProfit = profitDeque.pop();
                totalProfit += profit - minProfit;
            }
            res = Math.max(res, totalProfit + (long) categorySet.size() * categorySet.size());
        }

        return res;

    }


}