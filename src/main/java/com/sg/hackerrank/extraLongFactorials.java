package com.sg.hackerrank;

import java.math.BigDecimal;

public class extraLongFactorials {
    public static void run(int n){
        BigDecimal res = new BigDecimal("1");

        for(int i=2;i<=n;i++){
            res = res.multiply(new BigDecimal(i));
        }

        System.out.println(res);
    }
}
