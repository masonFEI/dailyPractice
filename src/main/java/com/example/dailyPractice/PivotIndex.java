package com.example.dailyPractice;

public class PivotIndex {



    public int pivotIndex(int[] nums) {
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        int leftS = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftS * 2 == s - nums[i]) {
                return i;
            }
            leftS += nums[i];
        }
        return -1;
    }

}
