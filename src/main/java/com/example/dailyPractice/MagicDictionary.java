package com.example.dailyPractice;

public class MagicDictionary {


    int N = 100 * 100, M = 26, idx = 0;
    int[][] tr = new int[N][M];
    boolean[] isEnd = new boolean[N * M];
    void add(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (tr[p][u] == 0) tr[p][u] = ++idx;
            p = tr[p][u];
        }
        isEnd[p] = true;
    }
    boolean query(String s, int idx, int p, int limit) {
        if (limit < 0) return false;
        if (idx == s.length()) return isEnd[p] && limit == 0;
        int u = s.charAt(idx) - 'a';
        for (int i = 0; i < 26; i++) {
            if (tr[p][i] == 0) continue;
            if (query(s, idx + 1, tr[p][i], i == u ? limit : limit - 1)) return true;
        }
        return false;
    }



    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) add(s);
    }

    public boolean search(String searchWord) {
        return query(searchWord, 0, 0, 1);
    }


}
