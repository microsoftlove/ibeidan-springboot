package com.ibeidan.sort;

/**
 * 插入排序
 * 插入排序算法通过对未排序的数据执行逐个插入至合适的位置而完成排序工作。
 * @author lee
 * DATE 2020/7/30 14:16
 */
public class InsertSort {

    public static void main(String[] args) {
        int [] a = {1,5,2,6,9,3,0};


        int i , j ,t ;

        for ( i = 1; i < a.length; i++) {

            t = a[i]; //取出待比较的值 右侧的值
            j = i - 1;//左侧的值

            while (j >= 0 && t < a[j]){ //左边的值比右边的值大
                a[j+1] = a[j];//左边的值 右移一位 交互位置
                j--; //控制左边的循环次数
            }
            a[j+1] = t ; //控制最终的插入位置


            System.out.println("第" + i + "步排序结果：");
            for (int h = 0; h < a.length  ; h++) {

                System.out.print(" "+a[h]);
            }
            System.out.println();


        }

    }

    public static void test(int a[]){
        int temp;
        int left;

        for (int i = 1; i < a.length; i++) {
            temp = a[i] ; //取出右侧的值
            left = a[i-1] ;//左侧的值
            int j = i -1 ;
            while (j >=0 && left > temp) {
                a[j+1] = left;
                j--;
            }
            a[j+1] = temp;
        }
    }
}
