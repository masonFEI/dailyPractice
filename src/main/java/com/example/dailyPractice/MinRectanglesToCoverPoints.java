package com.example.dailyPractice;

import java.util.Arrays;
import java.util.Comparator;

public class MinRectanglesToCoverPoints {



    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        int ans = 0;
        int x2 = -1;
        for (int[] p : points) {
            if (p[0] > x2) {
                ans++;
                x2 = p[0] + w;
            }
        }
        return ans;
    }


}
