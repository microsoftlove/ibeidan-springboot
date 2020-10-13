package com.ibeidan.sort.leetcode;

/**
 * @author lee
 * DATE 2020/10/12 13:51
 * 删除有序数组中的重复项
 */
public class RemoveDuplicate {

    public static int removeDuplicate(int[] repeatArr){
            int p = 0;
            int q = 1;
            while (q < repeatArr.length){
                if (repeatArr[p] != repeatArr[q]) {
                    repeatArr[p+1] = repeatArr[q];
                    q++;
                    p++;
                }
                q++;
            }
        for (int i = 0; i < repeatArr.length; i++) {
            System.out.print(repeatArr[i]+",");
        }

            return p + 1;

    }

    public static void main(String[] args) {
        int[] repeateArr = new int[]{0,0,1,1,2,2,3,3,4,4};
        int l = removeDuplicate(repeateArr);
        System.out.println("移除重复项后，长度为："+l);
    }


}
