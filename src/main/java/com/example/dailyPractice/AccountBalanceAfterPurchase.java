/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

/**
 * AccountBalanceAfterPurchase
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-06-12 11:20
 */
public class AccountBalanceAfterPurchase {


    public static void main(String[] args) {

    }


    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int yu = purchaseAmount % 10;
        int shang = purchaseAmount / 10;
        // 余数比5大，则向上取证
        if (yu >= 5) {
            return 100 - (shang + 1) * 10;
        } else {
            // 否则用原来的商
            return 100 - (shang) * 10;
        }
    }


}