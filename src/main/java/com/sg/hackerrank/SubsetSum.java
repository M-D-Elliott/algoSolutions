package com.sg.hackerrank;

import java.util.Arrays;
import java.util.Collections;

public class SubsetSum {

    // return message for failed edge checks.
    private static String IMPOSSIBLE = "Cannot form equal subsets";

    // rudimentary time checking int.
    private static int iters = 0;

    // test cases
    // prepared 11:10 p.m. 02/24/2020
    public static void main(String[] args) {

        // basic test case for three subsets
        System.out.println("TEST SUBSET 3 ON int[]{1,3,2,3}");
        boolean ans = SubsetSum.prepareAndCheckSubset(new int[]{1, 3, 2, 3}, 3);
        System.out.println(ans);
        iters = 0;
        System.out.println("");

        //test case specified in interview:
        System.out.println("TEST SUBSET 2 ON int[]{1,3,2}");
        ans = SubsetSum.prepareAndCheckSubset(new int[]{1, 3, 2}, 2);
        System.out.println(ans);
        iters = 0;
        System.out.println("");

        //test for edge case subset size of 1
        System.out.println("TEST SUBSET 1 ON int[]{1,1,1}");
        ans = SubsetSum.prepareAndCheckSubset(new int[]{1, 1, 1}, 1);
        System.out.println(ans);
        iters = 0;
        System.out.println("");

        //test for edge case int array with 1 value
        System.out.println("TEST SUBSET 2 ON int[]{4}");
        ans = SubsetSum.prepareAndCheckSubset(new int[]{4}, 2);
        System.out.println(ans);
        iters = 0;
        System.out.println("");

        // test for unbalanced, but
        // initially acceptable case.
        System.out.println("TEST SUBSET 3 ON int[]{4,3,2,3}");
        ans = SubsetSum.prepareAndCheckSubset(new int[]{4, 3, 2, 3}, 3);
        System.out.println(ans);
        iters = 0;
        System.out.println("");
    }

    // I designed the basic setup before I checked
    // the answer through the link specified.
    // I could not quickly come to the recursive answer
    // and used the online solution as a basis.
    public static boolean prepareAndCheckSubset(int[] arr, int subsetSize) {

        // gathers arr length into int len
        // to eliminate calculating this value
        // more than once.
        int len = arr.length;

        // edge case checks
        if (subsetSize == 1) {
            return true;
        } else if (subsetSize > len) {
            System.out.println(IMPOSSIBLE);
            return false;
        }

        // simply sums the array,
        // using the length calculated
        // previously
        int totalSum = sumPrimArr(len, arr);

        // modification that allows
        // specified subset size
        // instead of simply 2 subsets as max.
        if (totalSum % subsetSize != 0) {
            System.out.println(IMPOSSIBLE);
            return false;
        }

        // creates a subset array of
        // soon to be summed values
        // the size specified by the algo
        // user.
        int[] subset = new int[subsetSize];

        // since totalSum was previously determined
        // to be equally divisible by subsetSize
        // now gets the result of division
        // instead of checking 0 remainder.
        int goalSum = totalSum / subsetSize;

        // uses another solution found online
        // to sort a prim array using Arrays.sort()
        // then reverses it using simple iteration.
        reverseSortPrimArray(arr);

        // gets the overall boolean from the full recursion.
        boolean ans = recurseSubsets(arr, subset, 0, goalSum);

        // prints iters for speed checking.
        System.out.println("iters: " + iters);

        return ans;

    }

    private static boolean recurseSubsets(int[] arr, int[] subset, int index, int goalSum) {
        // checks if all values in subset are equal.
        if (arrIsBalanced(subset, goalSum)) {
            return true;
        }

        // returns false if recursive portion
        // of iteration exceeds original array length,
        // exiting that tier of recursion.
        if (index >= arr.length) {
            return false;
        }

        // iterates across each value in subset
        // adding currently indexed arr value
        // skips addition of this subset value
        // if it is already full.
        for (int i = 0; i < subset.length; ++i) {
            if (subset[i] >= goalSum) {

                // modification to exit
                // recursion and break
                // subsets down, shifting right.
                // was continue as shown:
                // continue;
                return false;
            }

            // adds the currently indexed value
            // to the running total of the currently
            // checked subset.
            subset[i] += arr[index];

            // rudiementary speed checking int.
            iters++;

            // if this returns true it means
            // that all values are balanced,
            // by checking in the next recursion
            // so all recursion now collapses.
            if (recurseSubsets(arr, subset, index + 1, goalSum)) {
                return true;
            }

            // since the entire recursion is not broken
            // we can assume the answer has not succeeded
            // so we now have to backtrack
            // and begin shifting the values right.
            subset[i] -= arr[index];
        }

        // all iterations were checked
        // and all recursions performed
        // so balancing is not possible.
        return false;
    }

    // sums all the values in an int array
    // and returns sum.
    private static int sumPrimArr(int len, int[] arr) {

        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += arr[i];
        }

        return sum;
    }

    // reverses a primitve int array
    // as Arrays.sort + reverse comparator
    // does not work on primitive int arrays.
    public static void reversePrimArray(int[] input) {
        int last = input.length - 1;
        int middle = input.length / 2;
        for (int i = 0; i <= middle; i++) {
            int temp = input[i];
            input[i] = input[last - i];
            input[last - i] = temp;
        }
    }

    // combines Arrays.sort with the simple
    // primitive array reversing algo.
    private static void reverseSortPrimArray(int[] arr) {
        Arrays.sort(arr);
        reversePrimArray(arr);
    }

    // simply an ovverride so that 
    // any int could be passed in and compared.
    // assumes int array has at least 1 member.
    private static boolean arrIsBalanced(int[] arr) {
        return arrIsBalanced(arr, arr[0]);
    }

    // first checks if the goal value is equal to
    // the first value in the array, in the case of
    // the above algo this is the subset.
    // made generic for reusability.
    private static boolean arrIsBalanced(int[] arr, int goalSum) {
        if (arr[0] == goalSum) {

            int len = arr.length;

            for (int j = 1; j < len; j++) {
                if ((arr[j] != goalSum)) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
