package com.example.dailyPractice;

public class FindLUSlengthI {







    public static void main(String[] args) {

    }


    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }



}
