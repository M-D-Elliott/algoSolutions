package com.sg.hackerrank;

import java.util.Arrays;

public class NewYearsChaos {

    public static final String TOO_CHAOTIC = "Too chaotic";

    public static final int SWAP_TOLERANCE = 2;

    // Complete the minimumBribes function below.
    static String minimumBribesBubble(int[] q) {
        int swaps = 0;
        int n = q.length;
        int temp = 0;

        if (q[0] - SWAP_TOLERANCE > 1) {
            System.out.println(TOO_CHAOTIC);
            return TOO_CHAOTIC;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (q[j - 1] > q[j]) {
                    if (q[j - 1] - SWAP_TOLERANCE > j) {
                        System.out.println(TOO_CHAOTIC);
                        return TOO_CHAOTIC;
                    }
                    temp = q[j - 1];
                    q[j - 1] = q[j];
                    q[j] = temp;

                    swaps++;
                }

            }
        }

        String ret = "" + swaps;

        System.out.println(ret);

        return ret;
    }

    // Complete the minimumBribes function below.
      public static String minimumBribes(int[] q) {

        int swaps = 0;

        for (int i = 0; i < q.length; i++) {
            int shift = q[i] - i - 1;
            
            if (shift > SWAP_TOLERANCE) {
                System.out.println(TOO_CHAOTIC);
                return TOO_CHAOTIC;
            } 

            if (shift > 0) {
                swaps += shift;
            }
        }

        String ret = "" + swaps;
        System.out.println(ret);

        return ret;
    }
}
