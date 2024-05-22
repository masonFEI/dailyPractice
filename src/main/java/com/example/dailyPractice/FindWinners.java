/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
     * 哈希表+排序
     * @param matches
     * @return
     */

    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lossCount = new HashMap<>();
        for (int[] m : matches) {
            if (!lossCount.containsKey(m[0])) {
                lossCount.put(m[0], 0);
            }
            lossCount.merge(m[1], 1, Integer::sum);
        }

        List<List<Integer>> ans = List.of(new ArrayList<>(), new ArrayList<>());
        for (Map.Entry<Integer, Integer> e : lossCount.entrySet()) {
            int cnt = e.getValue();
            if (cnt < 2) {
                ans.get(cnt).add(e.getKey());
            }
        }

        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;

    }

}