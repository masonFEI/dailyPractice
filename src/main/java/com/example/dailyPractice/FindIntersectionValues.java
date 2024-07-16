/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.*;

/**
 * FindIntersectionValues
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-07-16 20:28
 */
public class FindIntersectionValues {


//    输入：nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]
//
//    输出：[3,4]

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {

        Map<Integer, Integer> numsCountMap1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> numsCountMap2 = new HashMap<Integer, Integer>();

        for (int value : nums1) {
            if (numsCountMap1.containsKey(value)) {
                numsCountMap1.put(value, numsCountMap1.get(value) + 1);
            } else {
                numsCountMap1.put(value, 1);
            }
        }

        for (int j : nums2) {
            if (numsCountMap2.containsKey(j)) {
                numsCountMap2.put(j, numsCountMap2.get(j) + 1);
            } else {
                numsCountMap2.put(j, 1);
            }
        }
        List<Integer> listAnswer1 = new ArrayList<>();
        List<Integer> listAnswer2 = new ArrayList<>();
        numsCountMap2.forEach((k, v) -> {
            if (numsCountMap1.containsKey(k)) {
                listAnswer2.add(v);
            }
        });
        numsCountMap1.forEach((k, v) -> {
            if (numsCountMap2.containsKey(k)) {
                listAnswer1.add(v);
            }
        });

        Optional<Integer> reduce1 = listAnswer1.stream().reduce(Integer::sum);
        Optional<Integer> reduce2 = listAnswer2.stream().reduce(Integer::sum);

        int[] res = new int[2];
        reduce1.ifPresent(integer -> res[0] = integer);
        reduce2.ifPresent(integer -> res[1] = integer);
        return res;


    }

}