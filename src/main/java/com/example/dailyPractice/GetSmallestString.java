package com.example.dailyPractice;

public class GetSmallestString {


    public static void main(String[] args) {

//        String s = "zbbz";
//        int k = 3;

        String s = "xaxcd";
        int k = 4;



//        String s = "kb";
//        int k = 16;

        String smallestString = getSmallestString(s, k);

        System.out.println(smallestString);


    }


    public static String getSmallestString(String s, int k) {
        char[] charArray = s.toCharArray();
        int end = 123;
        int start = 97;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'a') {
                continue;
            }

            if (k > 0) {
                int tmp = 0;

                int minLength = Math.min(end - charArray[i], charArray[i] - start);
                tmp = minLength;
                if (minLength <= k) {
                    charArray[i] = 'a';
                } else {
                    tmp = k;
                    charArray[i] = (char) (charArray[i] - k);
                }
                k = k - tmp;
            }
        }

        return new String(charArray);


    }


}
