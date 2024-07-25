package com.example.dailyPractice;

public class MinimumOperations {




    public int minimumOperations(String num) {
        int zero = num.length() - (num.contains("0") ? 1 : 0);
        return min(zero, f(num, "00"), f(num, "25"), f(num, "50"), f(num, "75"));
    }

    private int f(String num, String tail) {
        int n = num.length();
        int i = num.lastIndexOf(tail.charAt(1));
        if (i <= 0) {
            return n;
        }
        i = num.lastIndexOf(tail.charAt(0), i - 1);
        return i < 0 ? n : n - i - 2;
    }

    private int min(int x, int... y) {
        for (int v : y) {
            x = Math.min(x, v);
        }
        return x;
    }



}
