package com.example.dailyPractice;

import java.util.HashSet;
import java.util.Set;

public class SmallestBeautifulString {


    public String smallestBeautifulString(String s, int k) {
        for (int i = s.length() - 1; i >= 0; i--) {
            Set<Character> blockedCharacters = new HashSet<Character>();
            for (int j = 1; j < 3; j++) {
                if (i - j >= 0) {
                    blockedCharacters.add(s.charAt(i - j));
                }
            }
            for (int j = 1; j < 4; j++) {
                if (s.charAt(i) - 'a' + j + 1 <= k && !blockedCharacters.contains((char) (s.charAt(i) + j))) {
                    return generate(s, i, j);
                }
            }
        }
        return "";
    }

    public String generate(String s, int idx, int offset) {
        char[] res = s.toCharArray();
        res[idx] += offset;
        for (int i = idx + 1; i < s.length(); i++) {
            Set<Character> blockedCharacters = new HashSet<Character>();
            for (int j = 1; j < 3; j++) {
                if (i - j >= 0) {
                    blockedCharacters.add(res[i - j]);
                }
            }
            for (int j = 0; j < 3; j++) {
                if (!blockedCharacters.contains((char) ('a' + j))) {
                    res[i] = (char) ('a' + j);
                    break;
                }
            }
        }
        return new String(res);
    }



}
