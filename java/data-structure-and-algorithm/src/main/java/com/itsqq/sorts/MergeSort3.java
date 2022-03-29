package com.itsqq.sorts;

/**
 * @author sfqqyq
 * @date 2022年03月29日 9:30 上午
 * @desc 归并排序算法实现3-自己
 */
public class MergeSort3 {

    /**
     * @desc 数组排序
     * @author sfqqyq
     * @date 2022/3/29 9:31 上午
     * @param a 原始数组
     * @param n 原始数组长度
     */
    public static void mergeSort(int[] a,int n){
        mergeSortInternally(a,0,n-1);
    }
    /**
     * @desc 递归分解数组，以及合并排序后的数组
     * @author sfqqyq
     * @date 2022/3/29 9:33 上午
     * @param a 原始数据
     * @param p 在原始数组首位的下标
     * @param r 在原始数据末尾的下标
     */
    public static void mergeSortInternally(int a[],int p,int r){

        // 递归结束条件
        if(p>=r)return;

        // 计算p...r的中间下标 防止p+r 超过int的最大值
        int q=p+(r-p)/2;

        // p...q
        mergeSortInternally(a,p,q);
        // q+1...r
        mergeSortInternally(a,q+1,r);

        // 合并两边数组
        merge(a,p,q,r);

    }
    /**
     * @desc 合并两个数组，不加哨兵方式
     * @author sfqqyq
     * @date 2022/3/29 9:35 上午
     * @param a 原始数组
     * @param p 在原始数组首位的下标
     * @param q p...r 的中间下标
     * @param r 在原始数组的末尾下标
     */
    public static void merge(int[] a,int p,int q,int r){

        // 初始化下标
        int i=p;// 左边数组下标
        int j=q+1;// 右边数组下标
        int k=0;// 临时数组下标
        int[] tmp=new int[r-p+1];// r-p+1是a数组的长度

        // 将数据存放在临时数组中
        while (i<=q && j<=r){
            if(a[i]<a[j]){
                tmp[k++]=a[i++];
            }else if(a[i]==a[j]){
                tmp[k++]=a[i++];
                tmp[k++]=a[j++];
            }else {
                tmp[k++]=a[j++];
            }
        }

        // 判断哪个数组没有清空
        int start=i;
        int end=q;
        if(j<=r){
            start=j;
            end=r;
        }
        // 将余下的数据放在临时数组中
        while (start<=end){
            tmp[k++]=a[start++];
        }
        // 将tmp数据放在a中
        for (i = 0; i < r-p+1; i++) {
            // a的下标从p开始，不是从0开始
            a[p+i]=tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] a=new int[]{2,5,1,3,2,1};
        mergeSort(a,a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }
}
