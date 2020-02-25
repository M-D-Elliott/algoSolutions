package com.sg.hackerrank;

import java.util.Arrays;

public class GreatestProduct {
    public int run(int[] a){
        int len = a.length;
        
        Arrays.sort(a);
        
        if(len > 1){
            int leastProd = 0;
            int maxProd = 0;
            
            if(a[0] < 0 && a[1] < 0){
                leastProd = a[0] * a[1];
            }
            
            if(a[len - 1] > 0 && a[len - 2] > 0){
                maxProd = a[len-1] * a[len-2];
            }
            
            return (leastProd > maxProd) ? leastProd : maxProd;
        } else {
            return a[0];
        }
    }
}
