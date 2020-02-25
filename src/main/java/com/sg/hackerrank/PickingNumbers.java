package com.sg.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {
     public static int pickingNumbers(List<Integer> a) {
        if(a.size() == 1){
            return 1;
        }

        int i = 0;

        int curr = a.get(i);

        List<Integer> ret = new ArrayList<>();
//        a.sort(c);
        ret.add(0);
        for(Integer val : a){
            if(curr + 1 != val){
                i++;
            } else {
                ret.set(i, ret.get(i) + 1);
                if(curr == val){
                    ret.set(i + 1, ret.get(i + 1) + 1);
                }
            }

        }

        return Collections.max(ret);
    }
}
