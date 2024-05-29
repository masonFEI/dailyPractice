/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.HashMap;
import java.util.Map;

/**
 * MaximumLength
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-05-29 10:36
 */
public class MaximumLength {

//    2981-找出出现至少三次的最长特殊子字符串I
//    给你一个仅由小写英文字母组成的字符串 s 。
//
//    如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字符串。
//
//    返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。

    public static void main(String[] args) {
        String s = "aaaa";
//        String s = "abcdef";
//        String s = "abcaba";
        int res = maximumLength(s);
        System.out.println(res);
    }


    public static int maximumLength(String s) {
        // 与字符串长度相差为2，则才能切割出来3个字符串
        int diffLength = s.length() - 2;
        int totalLength = s.length();
        int left = 0;
        int right = diffLength - 1;
        char[] charArray = s.toCharArray();
        Map<String, Integer> diffLengthCountMap = new HashMap<>();
        while (diffLength > 0) {

            while (right < totalLength) {
                int index = left;
                boolean isSpecial = true;
                while (index <= right) {
                    // 每个char相等，才是特殊字符
                    if (charArray[index] == charArray[left]) {
                        index++;
                    } else {
                        isSpecial = false;
                        break;
                    }
                }

                if (isSpecial) {
                    String mapKey = s.substring(left, right + 1);
                    int specialCount = diffLengthCountMap.getOrDefault(mapKey, 0);
                    specialCount++;
                    if (specialCount >= 3) {
                        return mapKey.length();
                    } else {
                        diffLengthCountMap.put(mapKey, specialCount);
                    }
                }
                left++;
                right++;
            }
            diffLength--;
            left = 0;
            right = diffLength - 1;
        }

        return -1;

    }


}