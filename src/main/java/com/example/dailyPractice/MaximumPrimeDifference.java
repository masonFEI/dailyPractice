package com.example.dailyPractice;

public class MaximumPrimeDifference {





    public int maximumPrimeDifference(int[] nums) {
        int i = 0;
        while (!isPrime(nums[i])) {
            i++;
        }
        int j = nums.length - 1;
        while (!isPrime(nums[j])) {
            j--;
        }
        return j - i;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n >= 2;
    }

}
