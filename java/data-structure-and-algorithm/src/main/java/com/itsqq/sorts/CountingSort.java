package com.itsqq.sorts;

/**
 * @author sfqqyq
 * @date 2022年03月31日 2:51 下午
 * @desc 计数排序
 */
public class CountingSort {

    /**
     * @desc 计数排序
     * @author sfqqyq
     * @date 2022/3/31 3:27 下午
     * @param a 原始数据
     * @param n 数组长度
     */
    public static void countingSort(int[] a,int n){


        // 统计数据最大值
        int maxValue=a[0];
        for (int i = 0; i < n; i++) {
            if(a[i]>maxValue){
                maxValue=a[i];
            }
        }
        int[] c=new int[maxValue+1];
        // 统计人数
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }
        // 对数组进行顺序求和
        for (int i = 1; i < c.length; i++) {
            c[i]=c[i]+c[i-1];
        }

        // 巧妙的方式排序
        int[] R=new int[n];// 比较难理解
        for (int i = 0; i < n; i++) {
            int index=c[a[i]]-1;
            R[index]=a[i];
            c[a[i]]--;
        }

        // 将R数组数据给a
        for (int i = 0; i < n; i++) {
            a[i]=R[i];
        }

    }


    public static void main(String[] args) {

        // 原始数组
        int[] A={2,5,3,0,2,3,0,3};
        countingSort(A,A.length);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]+",");
        }


//        // 排好序的数组R
////        int[] R={0,0,2,2,3,3,3,5};
//
//        // 下标是分数，存储每个分数的人数
//        int[] C={2,0,2,3,0,1};
//
//        // 对C[6]进行顺序求和
//        C= new int[]{2, 2, 4, 7, 7, 8};
//
//        // 排好序的数组R
//        int[] R={0,0,2,2,3,3,3,5};
    }
}
