package com.example.dailyPractice;

import java.util.Arrays;

public class AddedInteger {




    public int addedInteger(int[] nums1, int[] nums2) {

        int sum1 = Arrays.stream(nums1).sum();
        int length = nums1.length;
        int sum2 = Arrays.stream(nums2).sum();
        return (sum2-sum1)/length;



    }


}
