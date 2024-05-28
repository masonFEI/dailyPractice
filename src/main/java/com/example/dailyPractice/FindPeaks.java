/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.ArrayList;
import java.util.List;

/**
 * FindPeaks
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-05-28 13:25
 */
public class FindPeaks {

    public static void main(String[] args) {
//        int[] mountain = {2, 4, 4};
        int[] mountain = {1,4,3,8,5};
        List<Integer> res = findPeaks(mountain);
        System.out.println(res);
    }

//    2951-找出峰值
//    给你一个下标从 0 开始的数组 mountain 。你的任务是找出数组 mountain 中的所有 峰值。
//
//    以数组形式返回给定数组中 峰值 的下标，顺序不限 。

    public static List<Integer> findPeaks(int[] mountain) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i < mountain.length - 1; i++) {

            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                res.add(i);
            }
        }

        return res;
    }


}