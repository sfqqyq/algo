package com.itsqq.sorts;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author sfqqyq
 * @date 2022年03月28日 3:00 下午
 * @desc 归并排序算法实现-自己
 */
public class MergeSort2 {

    /**
     * @desc 合并数组
     * @author sfqqyq
     * @date 2022/3/28 3:21 下午
     * @param a 原始数组
     * @param n 原始数组元素个数
     */
    public static void mergeSort(int[] a, int n){
        mergeSortInternally(a,0,n-1);
    }
    /**
     * @desc 递归调用函数
     * @author sfqqyq
     * @date 2022/3/28 3:22 下午
     * @param a 原始数组
     * @param p 数组开始下标
     * @param r 数组结尾下标
     */
    public static void mergeSortInternally(int[] a, int p,int r){

        // 结束条件
        if(p>=r)return;
        // 获取p...r中间值 , 为了防止p+r超过int的最大值。
        int q=p+(r-p)/2;

        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);
//        merge(a,p,q,r);
        mergeBySentry(a,p,q,r);
    }

    /**
     * @desc 数组合并
     * @author sfqqyq
     * @date 2022/3/28 3:25 下午
     * @param a 原始数组
     * @param p 开始下标
     * @param q p...r 中间下标
     * @param r 结尾下标
     */
    public static void merge(int[] a, int p,int q,int r){

        int i=p;// 左边数组的最小小标
        int j=q+1; // 右边数据的最小下标
        int k=0; // tmp数组的下标
        int[] tmp=new int[r-p+1];// 创建一个和a[p...r]一样空间的数组

        // 重组左右两边的数组
        while (i<=q&&j<=r){
            if(a[i]<a[j]){
                tmp[k++] = a[i++];
            }else if(a[i]==a[j]){
                tmp[k++]=a[i++];
                tmp[k++]=a[j++];
            }else {
                tmp[k++]=a[j++];
            }
        }

        int start = i;
        int end = q;
        if(j<=r){
            start=j;
            end=r;
        }

        while (start<=end){
            tmp[k++]=a[start++];
        }

        for(i=0;i<=r-p;i++){
            a[p+i]=tmp[i];
        }

    }

    /**
     * @desc 带哨兵的数组合并
     * @author sfqqyq
     * @date 2022/3/28 3:47 下午
     * @param arr 原始数组
     * @param p 数组起始下标
     * @param q p...r 中间下标
     * @param r 数组结束下标
     */
    private static void mergeBySentry(int[] arr, int p, int q, int r) {

        int[] leftArr=new int[q-p+2];
        int[] rightArr=new int[r-q+1];

        for (int i=p,j=0;i<=q;i++,j++){
            leftArr[j]=arr[i];
        }
        leftArr[q-p+1]= Integer.MAX_VALUE;

        for (int i=q+1,j=0;i<=r;i++,j++){
            rightArr[j]=arr[i];
        }
        rightArr[r-q]= Integer.MAX_VALUE;

        int i=0,j=0;
        int k=p;
        while (k<=r){
            if(leftArr[i]<rightArr[j]){
                arr[k++]=leftArr[i++];
            }else if(leftArr[i]==rightArr[j]){
                arr[k++]=leftArr[i++];
                arr[k++]=rightArr[j++];
            }else {
                arr[k++]=rightArr[j++];
            }
        }

    }

    public static void main(String[] args) {
        int[] a=new int[]{3,4,5,1,2,8,9,4};
        mergeSort(a,a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }

}
