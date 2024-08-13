/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

/**
 * IsArraySpecial
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-08-13 20:44
 */
public class IsArraySpecial {


    public boolean isArraySpecial(int[] nums) {

        if (nums.length == 1) {
            return true;
        }

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] % 2 == nums[i + 1] % 2) {
                return false;
            }
        }

        return true;

    }


}