/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * FindWinners
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-05-22 16:04
 */
public class FindWinners {

    public static void main(String[] args) {

        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        List<List<Integer>> winners = findWinners(matches);

        System.out.println(winners);



    }


    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        // 胜者
        List<Integer> winners = new ArrayList<>();
        // 败者，以及次数
        List<Integer> losers = new ArrayList<>();

        for (int i = 0; i < matches.length; i++) {
            winners.add(matches[i][0]);
            losers.add(matches[i][1]);
        }

        TreeSet<Integer> zeroLooseTime = new TreeSet<>();
        TreeSet<Integer> oneLooseTime = new TreeSet<>();

        Collections.sort(winners);
        Collections.sort(losers);
        int loopWinnerIndex = 0;
        int loopLoserIndex = 0;
        // 失败次数
        int failTime = 0;

        while (loopWinnerIndex < winners.size() && loopLoserIndex < losers.size()) {

            if (winners.get(loopWinnerIndex).equals(losers.get(loopLoserIndex))) {
                loopLoserIndex++;
                failTime++;
            } else if(winners.get(loopWinnerIndex) < losers.get(loopLoserIndex)){
                if (failTime == 0) {
                    zeroLooseTime.add(winners.get(loopWinnerIndex));
                } else if(failTime == 1){
                    oneLooseTime.add(winners.get(loopWinnerIndex));
                }
                loopWinnerIndex++;
                failTime = 0;
            } else {
                if (failTime == 0) {
                    zeroLooseTime.add(winners.get(loopWinnerIndex));
                } else if(failTime == 1){
                    oneLooseTime.add(winners.get(loopWinnerIndex));
                }
                loopLoserIndex++;
                failTime = 0;
            }
        }

        List<Integer> zeroList = zeroLooseTime.stream().collect(Collectors.toList());
        List<Integer> noeList = oneLooseTime.stream().collect(Collectors.toList());
        res.add(zeroList);
        res.add(noeList);
        return res;
    }

}