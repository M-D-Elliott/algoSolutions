package com.sg.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class RemoveArrayDupls {

    public static final int[] run(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            if(map.get(arr[i]) == null){
                map.put(arr[i], 1);
            } else {
                map.replace(arr[i], map.get(arr[i] + 1));
            }
        }
        
        int[] retArr = new int[map.keySet().size()];
        
        int index = 0;
        for (Integer integer : map.keySet()) {
            retArr[index] = integer;
            index++;
        }
        
        return retArr;

    }
}
