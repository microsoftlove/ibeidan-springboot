package com.ibeidan.sort;

import java.util.Arrays;

/**
 * @author lee
 * DATE 2020/10/14 15:35
 */
public class CalPercentile {


    public static double getPercentile(int[]A ,double p){
        double res = 0 ;
        Arrays.sort(A);
        double x = (A.length - 1) * p;
        int i = (int) x;
        double j = x -i ;//
        res = (1-j) * A[i] + j*A[i+1];
        return res;
    }

    public static void main(String[] args) {
        double p = 0.95;

        double res;
        int[] A1 = new int[10];
        int[] A = new int[]{
                110,
                100,
                100,
                100,
                50,
                50,
                50,
                61,
                61,
                71,
                100};
        int[] B = new int[]{
                50,
                50,
                50,
                50,
                50,
                50,
                50,
                50,
                50,
                50,
                50};
        for (int i = 0; i < 10; i++) {

            A1[i] = i;
            System.out.print(A1[i]+",");
        }
        res = getPercentile(A1, p);
        System.out.println(res);
    }

}
