package com.example.dailyPractice;

public class DistributeCandies {

    public static void main(String[] args) {

    }

    // 容斥原理
    // 不考虑limit的方案数，C(n+2,2)
    // 减去不合法方案数
    // 得到 C(n+2,2)−3⋅C(n−limit+1,2)+3⋅C(n−2⋅limit,2)−C(n−3⋅limit−1,2)
    // 讲解视频 https://www.bilibili.com/video/BV1Ww411T7JP/?vd_source=82c121d3d4cd2783d6bcb180125420fb

    public int distributeCandies(int n, int limit) {
        return c2(n + 2) - 3 * c2(n - limit + 1) + 3 * c2(n - 2 * limit) - c2(n - 3 * limit - 1);
    }

    private int c2(int n) {
        return n > 1 ? n * (n - 1) / 2 : 0;
    }


}
