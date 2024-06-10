package com.example.dailyPractice;

import java.util.Arrays;

public class NumRescueBoats {


//    881. 救生艇
    public static void main(String[] args) {

//        int[] people = {3,2,2,1};
//        int limit = 3;

        int[] people = {3, 5, 3, 4};
        int limit = 5;

        int res = numRescueBoats(people, limit);
        System.out.println(res);

    }


    public static int numRescueBoats(int[] people, int limit) {
        int res = 0;

        int[] sortedPeople = Arrays.stream(people).sorted().toArray();
        int left = 0;
        int right = sortedPeople.length - 1;
        while (left <= right) {
            if (sortedPeople[right] + sortedPeople[left] <= limit) {
                res++;
                right--;
                left++;
            } else if (sortedPeople[right] <= limit) {
                res++;
                right--;
            } else if (sortedPeople[left] <= limit) {
                res++;
                left++;
            }
        }

        return res;
    }


}
