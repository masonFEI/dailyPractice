/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * FindLUSlengthII
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-06-17 13:42
 */
public class FindLUSlengthII {


    public static void main(String[] args) {
//        String[] strs = {"aabbcc", "aabbcc", "cb"};
//        String[] strs = {"aaa","aaa","aa"};
//        String[] strs = {"aba","cdc","eae"};
//        String[] strs = {"aaa","aa"};
//        String[] strs = {"aabbcc", "aabbcc","c","e","aabbcd"};
//        String[] strs = {"abcabc","abcabc","abcabc","abc","abc","aab"};
        String[] strs = {"aaa","aaa","bbb","bbb","bb"};
        int luSlength = findLUSlength(strs);
        System.out.println(luSlength);
    }


//    示例 1：
//
//    输入: strs = ["aba","cdc","eae"]
//    输出: 3
//    示例 2:
//
//    输入: strs = ["aaa","aaa","aa"]
//    输出: -1


    public static int findLUSlength(String[] strs) {
        Map<String, Integer> unSpecialMap = new HashMap<>();

        // 筛选出重复的数据
        Map<String, Long> frequencyMap = Arrays.stream(strs)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> repeatStrMap = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        List<String> leftedString = new ArrayList<>();

        if (repeatStrMap.size() > 0) {
            int maxRepeatStrLength = repeatStrMap.keySet().stream()
                    .mapToInt(String::length)
                    .max()
                    .orElse(0);
            // 剔除重复的字符串的子字符串
            for (int i = 0; i < strs.length; i++) {
                if (!repeatStrMap.containsKey(strs[i]) && !isRepeatSonStr(repeatStrMap, strs[i],maxRepeatStrLength)) {
                    leftedString.add(strs[i]);
                }
            }
        } else {
            leftedString = List.of(strs);
        }

        // 取剩余字符串中长度最长的
        int maxLength = leftedString.stream()
                .mapToInt(String::length)
                .max()
                .orElse(-1);
        return maxLength;
    }


    /**
     * 是否是重复字符串的子字符串
     *
     * @return
     */
    private static boolean isRepeatSonStr(Map<String, Long> repeatStrMap, String strItem, int maxRepeatStrLength) {

        for (Map.Entry<String, Long> entry : repeatStrMap.entrySet()) {
            String repeatKey = entry.getKey();

            if(strItem.length()>=maxRepeatStrLength) {
                return false;
            }

            if (repeatKey.length() > strItem.length()) {

                int repeatKeyIndex = 0;
                int strItemIndex = 0;

                char[] repeatKeyCharArray = repeatKey.toCharArray();
                char[] strItemCharArray = strItem.toCharArray();

                while (repeatKeyIndex < repeatKeyCharArray.length && strItemIndex < strItemCharArray.length) {
                    if (repeatKeyCharArray[repeatKeyIndex] == strItemCharArray[strItemIndex]) {
                        repeatKeyIndex++;
                        strItemIndex++;
                    } else {
                        repeatKeyIndex++;
                    }
                }

                if (strItemIndex == strItemCharArray.length) {
                    return true;
                }
            }
        }
        return false;
    }


}