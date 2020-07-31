package com.ibeidan.sort;

/**
 * 冒泡排序
 * @author lee
 * DATE 2020/7/31 09:47
 */
public class BubbleSort extends AbstractSort{


    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        //int[] a = {1,5,2,6,9,3,0};
        int[] a = {1,2,4,3,2};
        bubbleSort.sort(a);
    }

    void sort(int[] a) {
        int temp;
        //外部循环控制所有的回合，内部循环代表每一轮的冒泡处理，先进行元素比较，再进行元素交换。
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i ; j++) {
                if (a[j] > a[j+1]){
                    temp = a [j] ;
                    a[j] = a[j+1] ;
                    a[j+1] = temp;
                }
            }

            super.printSort(a,i);


        }
    }

    /**
     * 这一版代码做了小小的改动，利用布尔变量isSorted作为标记。
     * 如果在本轮排序中，元素有交换，则说明数列无序；
     * 如果没有元素交换，说明数列已然有序，直接跳出大循环。
     **/
    void sort2(int[] a){
        int temp;
        for (int i = 1; i < a.length; i++) {
            boolean isSorted = true ;
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j+1]){
                    temp = a[j] ;
                    a[j] = a[j+1] ;
                    a[j+1] = temp;
                    isSorted = false ;
                }
            }
            if (isSorted){
                break;
            }
            super.printSort(a,i);
        }
    }
}
