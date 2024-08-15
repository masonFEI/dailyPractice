/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * MaxScore3148
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-08-15 15:57
 */
public class MaxScore3148 {


    public static void main(String[] args) {
        int[][] gridArray = {{9, 5, 7, 3}, {8, 9, 6, 1}, {6, 7, 14, 3}, {2, 5, 3, 1}};


        List<List<Integer>> grid = IntStream.range(0, gridArray.length)
                .mapToObj(rowIndex ->
                        IntStream.range(0, gridArray[rowIndex].length)
                                .mapToObj(i -> gridArray[rowIndex][i])
                                .collect(Collectors.toList())
                )
                .collect(Collectors.toList());

        int i = maxScore(grid);
        System.out.println(i);


    }


    public static int maxScore(List<List<Integer>> grid) {
        int[][] minNum = new int[grid.size()][grid.get(0).size()];
        // 寻找个最低的起点，然后计算终点与起点的差值
        // 初始化最小值
        minNum[0][0] = grid.get(0).get(0);
        for (int i = 1; i < grid.size(); i++) {
            minNum[i][0] = Math.min(grid.get(i).get(0), minNum[i - 1][0]);
        }

        for (int j = 1; j < grid.get(0).size(); j++) {
            minNum[0][j] = Math.min(grid.get(0).get(j), minNum[0][j - 1]);
        }

        for (int i = 1; i < grid.size(); i++) {
            for (int j = 1; j < grid.get(0).size(); j++) {
                minNum[i][j] = Math.min(Math.min(minNum[i - 1][j], minNum[i][j - 1]), grid.get(i).get(j));
            }
        }
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                if (i == 0) {
                    maxScore = Math.max(maxScore, grid.get(i).get(j) - minNum[i][j - 1]);
                } else if (j == 0) {
                    maxScore = Math.max(maxScore, grid.get(i).get(j) - minNum[i - 1][j]);
                } else {
                    maxScore = Math.max(maxScore, grid.get(i).get(j) - Math.min(minNum[i - 1][j], minNum[i][j - 1]));
                }
            }
        }

        return maxScore;
    }


}