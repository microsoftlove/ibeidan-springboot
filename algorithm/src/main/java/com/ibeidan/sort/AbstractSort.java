package com.ibeidan.sort;

/**
 * @author lee
 * DATE 2020/7/31 09:54
 */
public abstract class AbstractSort {



    abstract void sort(int[] a);

    public void printSort(int[] a,int i){
         System.out.println("第" + i + "步排序结果：");
         for (int h = 0; h < a.length  ; h++) {

             System.out.print(" "+a[h]);
         }
         System.out.println();
     }
}
