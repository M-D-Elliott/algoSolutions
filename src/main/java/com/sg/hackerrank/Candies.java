package com.sg.hackerrank;

import java.util.Arrays;

public class Candies {
    
    private static int BASE_CANDY = 1;

    static long candies(int n, int[] arr) {

        long ret = 0;

        if (n == 1) {
            return ret;
        }
        
        int[] allBonusCandies = new int[n];
        
        allBonusCandies[0] = 1;
        
        for(int i=1;i<n;i++){
            allBonusCandies[i] = (arr[i] > arr[i-1]) ? (allBonusCandies[i-1] + 1) : 1;
        }
        
        ret += allBonusCandies[n - 1];
        
        for(int i=n-2;i>=0;i--){
            allBonusCandies[i] = (arr[i] > arr[i+1] && (arr[i+1] + 1) > arr[i]) ? (allBonusCandies[i+1] + 1) : allBonusCandies[i];
            ret += allBonusCandies[i];
        }

        System.out.println(Arrays.toString(allBonusCandies));
        
        System.out.println(ret);
        return ret;
    }
}
