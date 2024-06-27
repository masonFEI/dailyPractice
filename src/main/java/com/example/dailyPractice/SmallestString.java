/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

/**
 * SmallestString
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-06-27 15:12
 */
public class SmallestString {


    public static void main(String[] args) {
//        String s = "cbabc";
//        String s = "acbbc";
//        String s = "leetcode";
        String s = "aaaa";
        String s1 = smallestString(s);
        System.out.println(s1);
    }


    public static String smallestString(String s) {
        char[] charArray = s.toCharArray();
        boolean start = false;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 97) {
                if (start) {
                    break;
                }
            } else {
                start = true;
                charArray[i] = (char) (charArray[i] - 1);
            }
        }

        if (!start) {
            charArray[charArray.length - 1] = (char) 122;
        }

        return new String(charArray);
    }


}