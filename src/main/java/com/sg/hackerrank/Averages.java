package com.sg.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Averages {

    public static double mean(int[] q) {

        int n = q.length;

        double total
                = IntStream.of(q)
                        .sum();

        double ret = total / n;

        return ret;
    }

    public static double median(int[] q) {
        return median(q, true);
    }

    public static double median(int n, int[] q) {
        return median(n, q, true);
    }

    public static double median(int[] q, boolean needsSort) {
        int n = q.length;
        return median(n, q, needsSort);
    }

    public static double median(int n, int[] q, boolean needsSort) {

        if (needsSort) {
            q = IntStream.of(q)
                    .sorted()
                    .toArray();

        }

        boolean isEven = n % 2 == 0;

        double ret = 0;

        int middleElemIndex = (int) Math.ceil((n / 2));

        if (isEven) {

            double first = q[middleElemIndex];
            double second = q[middleElemIndex - 1];

            ret = (first + second) / 2;
        } else {
            ret = q[middleElemIndex];
        }

        return ret;
    }

    public static double mode(int[] q) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        int ret = q[0];

        int maxCount = 0;

        for (int i = 0; i < q.length; i++) {

            int value = q[i];

            boolean exists = countMap.get(value) != null;
            if (exists) {
                countMap.put(value, countMap.get(value) + 1);
            } else {
                countMap.put(value, 1);
            }

            int count = countMap.get(value);

            if (count > maxCount) {
                ret = value;
                maxCount = count;
            } else if (count == maxCount) {
                if (value < ret) {
                    ret = value;
                }
            }

        }

        return ret;
    }

    public static final double weightedMean(int n, int[] X, int[] W) {

        double dividend = 0;

        double divisor = 0;

        for (int i = 0; i < n; i++) {

            double weight = W[i];

            dividend += X[i] * weight;
            divisor += weight;
        }

        double ret = dividend / divisor;

        ret = round(ret, 1);

        return ret;
    }

    private static final double round(double value, int decimalPlaces) {

        double standardizer = Math.pow(10, decimalPlaces);

        double ret = Math.round(value * standardizer) / standardizer;

        return ret;
    }

    public static final double stDev(int n, int[] X) {

        double mean = mean(X);

        double total = 0;

        for (int i = 0; i < n; i++) {
            double dev = X[i] - mean;

            total += Math.pow(dev, 2);
        }

        double ret = Math.sqrt((total / n));

        ret = round(ret, 1);

        return ret;
    }

    public static final int[] quartiles(int n, int[] X) {

        int[] ret = new int[3];

        X = IntStream.of(X)
                .sorted()
                .toArray();

        boolean isEven = n % 2 == 0;

        int middleElemIndex = (int) Math.ceil((n / 2));

        if (isEven) {

            double first = X[(int) middleElemIndex];

            double second = X[(int) middleElemIndex - 1];

            ret[1] = (int) (first + second) / 2;

            ret[0] = (int) median(Arrays.copyOfRange(X, 0, (int) middleElemIndex), false);
            ret[2] = (int) median(Arrays.copyOfRange(X, (int) middleElemIndex, n), false);

        } else {
            ret[1] = X[(int) Math.ceil(middleElemIndex)];

            ret[0] = (int) median(Arrays.copyOfRange(X, 0, (int) middleElemIndex), false);
            ret[2] = (int) median(Arrays.copyOfRange(X, (int) middleElemIndex + 1, n), false);
        }

        return ret;
    }

    public static final double[] quartilesAsDouble(int n, int[] X) {
        double[] ret = new double[3];
        X = IntStream.of(X)
                .sorted()
                .toArray();

        boolean isEven = n % 2 == 0;

        int middleElemIndex = (int) Math.ceil((n / 2));

        if (isEven) {

            double first = X[(int) middleElemIndex];

            double second = X[(int) middleElemIndex - 1];

            ret[1] = (first + second) / 2;

            ret[0] = median(Arrays.copyOfRange(X, 0, middleElemIndex), false);

            ret[2] = median(Arrays.copyOfRange(X, middleElemIndex, n), false);

        } else {
            ret[1] = X[(int) Math.ceil(middleElemIndex)];
            ret[1] = round(ret[1], 1);

            ret[0] = median(Arrays.copyOfRange(X, 0, middleElemIndex), false);
            ret[2] = median(Arrays.copyOfRange(X, middleElemIndex + 1, n), false);
        }

        return ret;
    }
    
    public static final int sumArray(int n, int[] arr){
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret += arr[i];
        }
        
        return ret;
    }
    
//    public static final int[] composeFrequencyArray(int n, int[] X, int[] F){
//        
//        int[] ret = new int[sumArray(n, F)];
//        
//    }

    public static final double interQuartile(int n, int[] X) {
        double[] quartiles = quartilesAsDouble(n, X);

        return round(quartiles[2] - quartiles[0], 1);
    }
    
//    public static void main(String[] args) {
//       int n = scanner.nextInt();
//       scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//       int[] arr = new int[n];
//
//       String[] arrItems = scanner.nextLine().split(" ");
//       scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//       for (int i = 0; i < n; i++) {
//           int arrItem = Integer.parseInt(arrItems[i]);
//           arr[i] = arrItem;
//       }
//
//       scanner.close();
//
//       double ans = interQuartile(n, arr);
//
//       System.out.println(ans);
//
//    }
}
