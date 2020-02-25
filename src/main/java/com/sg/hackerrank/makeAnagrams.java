package com.sg.hackerrank;

import java.util.Arrays;
import java.util.stream.IntStream;

public class makeAnagrams {
    // Complete the makeAnagram function below.
    static int make(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        
        if(lengthA > lengthB){
            String temp = a;
            a = b;
            b = a;
            
            lengthA = a.length();
            lengthB = b.length();
        }
        
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        
        char charA = '0';
        char charB = '0';
        
        int deleteCount = 0;
        
        for (int i = 0; i < lengthA; i++) {
            
            charA = aChars[i];
            charB = bChars[lengthB - i];
            
            if(charA != charB){
                deleteCount+=2;
                lengthB--;
//                bChars = new char[lengthB]{}
            }
        }

        return deleteCount;
    }
    
    public static int make2(String a, String b){
        int [] letters = new int[26];
        
        for(char c : a.toCharArray()){
            letters[c-'a']++;
            System.out.println(Arrays.toString(letters));
        }
       
        for(char c : b.toCharArray()){
            letters[c-'a']--;
            System.out.println(Arrays.toString(letters));
        }
        
        int ret = IntStream.of(letters)
                .map(i -> Math.abs(i))
                .sum();
        
        return ret;
    }
}
