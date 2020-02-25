package com.sg.hackerrank;

import java.util.Scanner;

public class Decibinary {

    public static int toDecimal(String binary) {
        char[] binaryChars = binary.toCharArray();

        int ret = 0;

        int len = binaryChars.length - 1;

        for (int i = 0; i <= len; i++) {

            int value = binaryChars[i] - 48;

            int toSquare = (len - i);

            ret += value * Math.pow(2, toSquare);
        }

        System.out.println(ret);

        return ret;
    }

    public static String toBinary(int n) {
        int binary[] = new int[40];
        int index = 0;
        while (n > 0) {
            binary[index++] = n % 2;
            n = n / 2;
        }

        String ret = "";

        for (int i = index - 1; i >= 0; i--) {
            ret += binary[i];
        }

        System.out.println(ret);
        return ret;
    }

    public static int toDecimalFromDecibinary(String binary) {
        char[] binaryChars = binary.toCharArray();

        int ret = 0;

        int len = binaryChars.length - 1;

        for (int i = 0; i <= len; i++) {

            int value = binaryChars[i] - 48;

            int toSquare = (len - i);

            ret += value * Math.pow(2, toSquare);
        }

        System.out.println(ret);

        return ret;
    }
    
    //to decibinaryFromDecimal
    public static int decibinaryNumbers(){
        
        return 0;
    }
}
