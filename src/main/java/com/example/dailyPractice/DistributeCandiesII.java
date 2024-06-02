package com.example.dailyPractice;

import java.util.HashMap;
import java.util.Map;

public class DistributeCandiesII {


    public static void main(String[] args) {

    }

    public int distributeCandies(int[] candyType) {

        Map<Integer, Integer> candyTypeMap = new HashMap<>();

        for (int i = 0; i < candyType.length; i++) {
            candyTypeMap.put(Integer.valueOf(candyType[i]), i);
        }

        int candyTypeNum = candyTypeMap.size();

        if (candyType.length / 2 >= candyTypeNum) {
            return candyTypeNum;
        } else {
            return candyType.length / 2;
        }

    }


}
