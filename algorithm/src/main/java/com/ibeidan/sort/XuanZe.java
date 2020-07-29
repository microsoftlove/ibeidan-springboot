package com.ibeidan.sort;

/**
 * 选择排序
 * @author lee
 * DATE 2020/7/29 10:39
 */
public class XuanZe {


    public static void main(String[] args) {
        int [] a = {1,5,2,6,9,3,0};

        int index ;
        int temp ;

        for (int i = 0; i < a.length; i++) {
            index = i ;
            for (int j = i+1 ; j < a.length; j++) {
                if (a[j] < a[index]){
                    index = j; //循环遍历 数组 找出比第一个小的数的索引  先取出第一个数 赋值给 临时变量，再把找到了的最小数赋值给第一位，第一位的数放到找出值得位置上
                }
            }
            //交互两个数
            if (index != i){
                temp = a[i];
                a[i] = a[index] ;//交互位置
                a[index] = temp;
            }
            System.out.println("第" + (i+1)+"步排序结果：");
            for (int h = 0; h < a.length; h++) {
                System.out.print(" " +a[h] +" ");
            }
            System.out.println();
        }
    }

    public static void testMinMax(){
        int [] a = {1,5,2,6,9,3,0};
        int min = a[0];

        int max = a[0] ;
        for (int i = 1; i < a.length ; i++) {


            if (a[i] < min){
                min = a[i] ;
            }

            if (a[i] > max){
                max = a[i] ;
            }

        }
        System.out.println(min);
        System.out.println(max);
    }

}
