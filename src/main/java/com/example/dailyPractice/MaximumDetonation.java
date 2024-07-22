/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.*;

/**
 * MaximumDetonation
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-07-22 14:10
 */
public class MaximumDetonation {


    public static void main(String[] args) {
//        int[][] bombs = {{2, 1, 3}, {6, 1, 4}};
        int[][] bombs = {{1,1,100000}, {100000,100000,1}};

//        int[][] bombs = {{1,1,5}, {10,10,5}};
//        int[][] bombs = {{56,80,2},{55,9,10},{32,75,2},{87,89,1},{61,94,3},{43,82,9},{17,100,6},{50,6,7},{9,66,7},{98,3,6},{67,50,2},{79,39,5},{92,60,10},{49,9,9},{42,32,10}};
//        int[][] bombs = {{54, 95, 4}, {99, 46, 3}, {29, 21, 3}, {96, 72, 8}, {49, 43, 3}, {11, 20, 3}, {2, 57, 1}, {69, 51, 7}, {97, 1, 10}, {85, 45, 2}, {38, 47, 1}, {83, 75, 3}, {65, 59, 3}, {33, 4, 1}, {32, 10, 2}, {20, 97, 8}, {35, 37, 3}};

//        int[][] bombs = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};

        int res = maximumDetonation(bombs);
        System.out.println(res);
    }


//    给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。
//
//    炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs{i} = {xi, yi, ri} 。xi 和 yi 表示第 i 个炸弹的 X 和 Y 坐标，ri 表示爆炸范围的 半径 。

//    输入：bombs = {{2,1,3},{6,1,4}} 输出：2

//
//    1 <= bombs.length <= 100
//    bombs{i}.length == 3
//            1 <= xi, yi, ri <= 105


    public static int maximumDetonation(int[][] bombs) {

        // 1.先找出来每个炸弹直接关联引爆的炸弹
        // 2.根据关联数组，计算每个点可以到达的节点的数量（深搜）
        Map<Integer, List<Integer>> bombMap = new HashMap<>();
        for (int i = 0; i < bombs.length; i++) {
            int[] bombItem = bombs[i];
            int index = 0;
            while (index < bombs.length) {
                if (index != i) {
                    int[] bombThat = bombs[index];

                    int xDistance = Math.abs(bombItem[0] - bombThat[0]);
                    long xSquare = (long) xDistance * xDistance;

                    int yDistance = Math.abs(bombItem[1] - bombThat[1]);
                    long ySquare = (long) yDistance * yDistance;

                    // 距离过远，不会引爆，要在第一个炸弹的爆炸范围内
                    if (xSquare + ySquare <= (long) bombItem[2] * bombItem[2]) {
                        List<Integer> bombed = new ArrayList<>();
                        if (bombMap.containsKey(i)) {
                            bombed = bombMap.get(i);
                        }
                        bombed.add(index);
                        bombMap.put(i, bombed);
                    }
                }
                index++;
            }
        }
        int maxBomb = 1;

        Iterator<Map.Entry<Integer, List<Integer>>> iterator = bombMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Integer>> dsfParam = iterator.next();
            int dsfCount = dsf(bombMap, new HashMap<>(), new HashMap<>(), dsfParam.getKey());
            maxBomb = Math.max(maxBomb, dsfCount);
        }

        return maxBomb;

    }


    private static int dsf(Map<Integer, List<Integer>> bombMap, Map<Integer, Integer> bombedMap, Map<Integer, Integer> checkedBombMap, Integer nowBomb) {
        checkedBombMap.put(nowBomb, 1);
        List<Integer> nowBombChildren = bombMap.get(nowBomb);

        if (nowBombChildren == null || nowBombChildren.isEmpty()) {
            if (!bombedMap.containsKey(nowBomb)) {
                bombedMap.put(nowBomb, 1);
                return 1;
            } else {
                return 0;
            }
        }

        int bombsCount = 0;
        for (int i = 0; i < nowBombChildren.size(); i++) {
            if (!checkedBombMap.containsKey(nowBombChildren.get(i))) {
                bombsCount += dsf(bombMap, bombedMap, checkedBombMap, nowBombChildren.get(i));
            }
        }

        if (!bombedMap.containsKey(nowBomb)) {
            bombedMap.put(nowBomb, 1);
            bombsCount += 1;
        }

        return bombsCount;

    }


}