package com.example.dailyPractice;

public class MaxPointsInsideSquare {


    private int ans;

    public int maxPointsInsideSquare(int[][] points, String S) {
        char[] s = S.toCharArray();
        int left = -1;
        int right = 1_000_000_001;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(mid, points, s)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return ans;
    }

    boolean check(int size, int[][] points, char[] s) {
        int vis = 0;
        for (int i = 0; i < points.length; i++) {
            // 判断点是否在正方形中
            if (Math.abs(points[i][0]) <= size && Math.abs(points[i][1]) <= size) {
                int c = s[i] - 'a';
                if ((vis >> c & 1) > 0) { // c 在集合中
                    return false;
                }
                vis |= 1 << c; // 把 c 加入集合
            }
        }
        ans = Integer.bitCount(vis);
        return true;
    }


}
