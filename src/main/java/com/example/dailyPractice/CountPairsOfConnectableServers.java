/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * CountPairsOfConnectableServers
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-06-04 19:36
 */
public class CountPairsOfConnectableServers {


    public static void main(String[] args) {

    }


    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {

        // 将树的先后路径，边的权重转为一个map
        Map<Integer, Map<Integer, Integer>> weightMap = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int[] weightItem = edges[i];
            // 从改点可以到达的节点，以及权重
            Map<Integer, Integer> itemMap0 = new HashMap<>();
            Map<Integer, Integer> itemMap1 = new HashMap<>();
            if (weightMap.containsKey(weightItem[0])) {
                itemMap0 = weightMap.get(weightItem[0]);
            }
            if (weightMap.containsKey(weightItem[1])) {
                itemMap1 = weightMap.get(weightItem[1]);
            }
            itemMap0.put(weightItem[1], weightItem[2]);
            itemMap1.put(weightItem[0], weightItem[2]);
            weightMap.put(weightItem[0], itemMap0);
            weightMap.put(weightItem[1], itemMap1);
        }
        int size = weightMap.size();
        int[] res = new int[size];
        // 深搜
        weightMap.forEach((k, v) -> {
            if (v.size() < 2) {
                res[k] = 0;
            } else {
                List<Integer> countList = new ArrayList<Integer>();
                v.forEach((key, value) ->
                        countList.add(dfs(key, weightMap, 0, signalSpeed))
                );
                List<Integer> filterCollect = countList.stream().filter(p -> p != 0).collect(Collectors.toList());

                if (filterCollect.size() > 1) {
                    int product = filterCollect.stream().reduce(1, (a, b) -> a * b);
                    res[k] = product;
                } else {
                    res[k] = 0;
                }
            }
        });
        return res;
    }


    public int dfs(int node, Map<Integer, Map<Integer, Integer>> weightMap, int sum, int signalSpeed) {
        Map<Integer, Integer> dfsMap = weightMap.get(node);
        sum += dfsMap.get(node);
        // 累加值==signalSpeed的倍数，则数量加1
        if (sum % signalSpeed == 0) {

        }

        int finalSum = sum;
        dfsMap.forEach((k, v) -> {
            dfs(k, weightMap, finalSum, signalSpeed);
        });

    }


}