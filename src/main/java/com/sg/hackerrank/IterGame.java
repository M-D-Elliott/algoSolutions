package com.sg.hackerrank;

import java.util.Arrays;

public class IterGame {

    public static boolean canWin(int leap, int[] game) {

        boolean ret = true;

        int i = 0;

        if (game.length == 1 && game[i] == 0) {
            return ret;
        }

        while (ret) {
//            System.out.println(Arrays.toString(game));
//            System.out.println(i + 1 > game.length);
//            System.out.println(i + leap > game.length);
            if (i + 1 >= game.length || i + leap >= game.length) {
                ret = true;
                break;
            }
            
            game[i] = 1;
            if (game[i + 1] == 0) {
                i++;
            } else if (i + leap < game.length && game[i + leap] == 0) {
                i += leap;
            } else if (i - 1 >= 0 && game[i - 1] == 0) {
                i--;
            } else if (i - leap >= 0 && game[i - leap] == 0) {
                i -= leap;
            } else {
                ret = false;
                break;
            }

        }

        return ret;
    }
}
