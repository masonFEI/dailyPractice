/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

/**
 * TemperatureTrend
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-06-21 16:26
 */
public class TemperatureTrend {


    public static void main(String[] args) {
        int[] temperatureA = {21, 18, 18, 18, 31};
        int[] temperatureB = {34, 32, 16, 16, 17};
        int res = temperatureTrend(temperatureA, temperatureB);
        System.out.println(res);
    }


    public static int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int countMax = 0;
        int countTmp = 0;
        for (int i = 1; i < temperatureA.length; i++) {
            int changeA = temperatureA[i] - temperatureA[i - 1];
            int labelA = Integer.compare(changeA, 0);
            int changeB = temperatureB[i] - temperatureB[i - 1];
            int labelB = Integer.compare(changeB, 0);

            if (labelA == labelB) {
                countTmp++;
            }

            if (i == temperatureA.length - 1 || labelA != labelB) {
                countMax = Math.max(countMax, countTmp);
                countTmp = 0;
            }
        }

        return countMax;


    }


}