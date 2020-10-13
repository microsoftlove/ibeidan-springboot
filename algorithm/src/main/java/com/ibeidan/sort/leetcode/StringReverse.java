package com.ibeidan.sort.leetcode;

/**
 * @author lee
 * DATE 2020/10/10 09:59
 * 字符串反转
 */
public class StringReverse {


    public static char[] reverse (char[] strArr){

        int n = strArr.length;

        for (int left = 0,right = n - 1; left < right; ++left,--right) {
               char tmp = strArr[left];
               strArr[left] = strArr[right];
               strArr[right] = tmp;
        }

        System.out.println(String.valueOf(strArr));

        return strArr;

    }

    public static char[] reverse2 (char[] strArr){

        int n = strArr.length;
        char tmp ;
        for (int i = 0; i < n / 2; i++) {
            tmp = strArr[i];
            strArr[i] = strArr[n-i-1];
            strArr[n-i-1] = tmp;
        }
        System.out.println(String.valueOf(strArr));
        return strArr;

    }


    public static void main(String[] args) {
        char [] strArr = new char[]{'h','e','l','l','o'};
         // reverse(strArr);
          reverse2(strArr);
    }



}
