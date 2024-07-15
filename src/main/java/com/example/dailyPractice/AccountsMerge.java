/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.*;

/**
 * AccountsMerge
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-07-15 20:00
 */
public class AccountsMerge {


    public static void main(String[] args) {

    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, List<String>> emailsMap = new HashMap<String, List<String>>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> item = accounts.get(i);
            for (int j = 1; j < item.size(); j++) {
                if (emailsMap.containsKey(item.get(i))) {
                    List<String> allData = new ArrayList<>();
                    List<String> emails = emailsMap.get(item.get(i));
                    List<String> name = emails.subList(0, 1);
                    List<String> oldEmails = emails.subList(1, emails.size());
                    List<String> newEmails = item.subList(1, item.size());
                    oldEmails.addAll(newEmails);
                    Collections.sort(oldEmails);
                    allData.addAll(name);
                    allData.addAll(oldEmails);

                    for (int k = 1; k < allData.size(); k++) {
                        emailsMap.put(allData.get(k), allData);
                    }
                    break;
                } else {
                    emailsMap.put(item.get(i), item);
                }
            }

        }

        List<List<String>> resList = new ArrayList<>();

        for (List<String> emailList : emailsMap.values()) {
            resList.add(new ArrayList<>(emailList));
        }

        return resList;


    }

}