/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.*;

/**
 * FindWinners
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-05-22 16:04
 */
public class FindWinners {

    public static void main(String[] args) {

        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        List<List<Integer>> winners = findWinners(matches);

        System.out.println(winners);


    }

    /**
     * 2225 哈希表+排序
     *
     * @param matches
     * @return
     */

    public static List<List<Integer>> findWinners(int[][] matches) {

        // 失败次数统计
        Map<Integer, Integer> looseTimeMap = new HashMap<>();

        for (int i = 0; i < matches.length; i++) {

            int winner = matches[i][0];
            int looser = matches[i][1];

            if (!looseTimeMap.containsKey(winner)) {
                looseTimeMap.put(winner, 0);
            }

            if (looseTimeMap.containsKey(looser)) {
                looseTimeMap.put(looser, looseTimeMap.get(looser) + 1);
            } else {
                looseTimeMap.put(looser, 1);
            }

        }
        List<Integer> zeroLose = new ArrayList<>();
        List<Integer> oneLose = new ArrayList<>();

        looseTimeMap.forEach((k, v) -> {
            if (v == 0) {
                zeroLose.add(k);
            } else if (v == 1) {
                oneLose.add(k);
            }
        });

        Collections.sort(zeroLose);
        Collections.sort(oneLose);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(zeroLose);
        ans.add(oneLose);
        return ans;

    }

}