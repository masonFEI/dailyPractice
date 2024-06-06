package com.example.dailyPractice;

public class MinimumSteps {


    public static void main(String[] args) {

    }
    //2938. 区分黑球与白球
    //    累加每个 0 左边的 1 的个数
    public long minimumSteps(String s) {

        long ans = 0;
        int cnt1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt1++;
            } else {
                ans += cnt1;
            }
        }
        return ans;

    }

}
