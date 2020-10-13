package com.ibeidan.sort.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lee
 * DATE 2020/10/13 10:06
 * 判断给定数组中的元素是否有重复选项
 * 方式一：采用遍历比较
 * 方式二：先排序，再比较相邻两个元素是否重复
 * 方式三：利用set集合不重复特性，比较是否有重复
 */
public class JudgeDuplicates {


    public static boolean  loopItems(int[] items){

        for (int i = 0; i < items.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (items[i] == items[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean  sortCompare(int[] items){
        Arrays.sort(items);
        for (int i = 0; i < items.length -1; i++) {
            if (items[i]==items[i+1]){
                return true;
            }

        }
        return false;
    }

    public static boolean  setCompare(int[] items){
        Set set = new HashSet(items.length);
        for (int i = 0; i < items.length; i++) {
            if (set.contains(items[i])){
                return true;
            }
            set.add(items[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] items = new int[]{1,2,3,4,6};
       // boolean f= loopItems(items);
       // boolean f= sortCompare(items);
        boolean f= setCompare(items);
        System.out.println(f);
    }

}
