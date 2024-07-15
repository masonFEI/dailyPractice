/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * AccountsMerge
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-07-15 20:00
 */
public class AccountsMerge {


    public static void main(String[] args) {
//        String[][] accountsArray = {{"John","johnsmith@mail.com","john_newyork@mail.com"},
//        {"John","johnsmith@mail.com","john00@mail.com"}, {"Mary","mary@mail.com"},
//        {"John","johnnybravo@mail.com"}};
        String[][] accountsArray = {{"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"},
                {"Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"}, {"Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"},
                {"Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"},{"Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"}};

        List<List<String>> accountsList = Arrays.stream(accountsArray)
                .map(Arrays::stream)  // 将每个子数组转换为Stream
                .map(stream -> stream.collect(Collectors.toList()))  // 将每个Stream收集为List
                .collect(Collectors.toList());

        List<List<String>> res = accountsMerge(accountsList);
        System.out.println(res);
    }


    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> emailToIdx = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int k = 1; k < accounts.get(i).size(); k++) {
                emailToIdx.computeIfAbsent(accounts.get(i).get(k), x -> new ArrayList<>()).add(i);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        boolean[] vis = new boolean[accounts.size()];
        Set<String> emailSet = new HashSet<>(); // 用于收集 DFS 中访问到的邮箱地址
        for (int i = 0; i < accounts.size(); i++) {
            if (vis[i]) {
                continue;
            }
            emailSet.clear();
            dfs(i, accounts, emailToIdx, vis, emailSet);

            List<String> res = new ArrayList<>(emailSet);
            Collections.sort(res);
            res.add(0, accounts.get(i).get(0));

            ans.add(res);
        }
        return ans;
    }

    private static void dfs(int i, List<List<String>> accounts, Map<String, List<Integer>> emailToIdx, boolean[] vis, Set<String> emailSet) {
        vis[i] = true;
        for (int k = 1; k < accounts.get(i).size(); k++) {
            String email = accounts.get(i).get(k);
            if (emailSet.contains(email)) {
                continue;
            }
            emailSet.add(email);
            for (int j : emailToIdx.get(email)) { // 遍历所有包含该邮箱地址的账户下标 j
                if (!vis[j]) { // j 没有访问过
                    dfs(j, accounts, emailToIdx, vis, emailSet);
                }
            }
        }
    }

}