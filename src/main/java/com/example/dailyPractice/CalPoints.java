/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * CalPoints
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-07-29 16:38
 */
public class CalPoints {


    public static void main(String[] args) {


        String[] operations = {"5","-2","4","C","D","9","+","+"};
        int i = calPoints(operations);
        System.out.println(i);


    }


//    整数 x - 表示本回合新获得分数 x
//"+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
//            "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
//            "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。


    public static int calPoints(String[] operations) {

        List<Integer> scoreList = new ArrayList<>();
        int index = -1;
        for (String operation : operations) {
            if ("+".equals(operation)) {
                scoreList.add(scoreList.get(index) + scoreList.get(index - 1));
                index++;
            } else if ("D".equals(operation)) {
                scoreList.add(scoreList.get(index) * 2);
                index++;
            } else if ("C".equals(operation)) {
                scoreList.remove(index);
                index--;
            } else {
                scoreList.add(Integer.valueOf(operation));
                index++;
            }
        }

        int res = 0;
        Optional<Integer> sumOpt = scoreList.stream().reduce(Integer::sum);

        if (sumOpt.isPresent()) {
            res = sumOpt.get();
        }

        return res;


    }


}