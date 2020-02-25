package com.sg.hackerrank;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Abbreviation {

    public static String abbreviation(String a, String b) {

        String ret = "YES";

        int[] letters = new int[52];

        for (char c : a.toCharArray()) {
            if (0 + c > 96) {
                letters[c - 'a']++;
            } else {
                letters[c - 'A' + 26]++;
            }

        }

        for (char c : b.toCharArray()) {
            if (0 + c > 96) {
                letters[c - 'a']--;
            } else {
                letters[c - 'A' + 26]--;
            }
        }

        int firstHalf = letters.length / 2;

        System.out.println(Arrays.toString(letters));

        for (int i = 0; i < firstHalf; i++) {
            if (letters[i] < 0) {
                ret = "NO";
                System.out.println(ret);
                return ret;
            }
        }

        for (int i = firstHalf; i < letters.length; i++) {
            if (letters[i] != 0) {
//                if(Math.abs(letters[i - 26]) >= Math.abs(letters[i])){
//                    continue;
//                }
                if(letters[i - 26] + letters[i] >= 0){
                    continue;
                }
                ret = "NO";
                System.out.println(ret);
                return ret;
            }
        }

        System.out.println(ret);
        return ret;
    }
}
