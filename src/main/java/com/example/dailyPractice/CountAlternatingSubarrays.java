package com.example.dailyPractice;

public class CountAlternatingSubarrays {




    public long countAlternatingSubarrays(int[] nums) {
        long ans = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] != nums[i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            ans += cnt; // 有 cnt 个右端点下标为 i 的交替子数组
        }
        return ans;
    }


}
