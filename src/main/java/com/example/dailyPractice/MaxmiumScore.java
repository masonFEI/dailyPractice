package com.example.dailyPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxmiumScore {


    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int n = cards.length;
        int s = 0;
        for (int i = n - cnt; i < n; i++) {
            s += cards[i]; // 最大的 cnt 个数之和
        }
        if (s % 2 == 0) { // s 是偶数
            return s;
        }

        int x = cards[n - cnt];
        int ans = replacedSum(cards, cnt, s, x); // 替换 x
        for (int i = n - cnt + 1; i < n; i++) {
            if (cards[i] % 2 != x % 2) { // 找到一个最小的奇偶性和 x 不同的数
                ans = Math.max(ans, replacedSum(cards, cnt, s, cards[i])); // 替换
                break;
            }
        }
        return ans;
    }

    private int replacedSum(int[] cards, int cnt, int s, int x) {
        for (int i = cards.length - cnt - 1; i >= 0; i--) {
            if (cards[i] % 2 != x % 2) { // 找到一个最大的奇偶性和 x 不同的数
                return s - x + cards[i]; // 用 cards[i] 替换 s
            }
        }
        return 0;
    }


}
