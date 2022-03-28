package com.itsqq.sorts;

/**
 * @author sfqqyq
 * @date 2022年03月28日 9:53 上午
 * @desc 归并排序算法实现
 */
public class MergeSort {

    /**
     * @desc 排序方法
     * @author sfqqyq
     * @date 2022/3/28 2:02 下午
     * @param a 需要排序的数组
     * @param n 元素个数
     */
    public static void mergeSort(int[] a ,int n){
        mergeSortInternally(a,0,n-1);
    }

    /**
     * @desc 递归调用函数
     * @author sfqqyq
     * @date 2022/3/28 2:03 下午
     * @param a 需要排序的原始数组
     * @param p 开始坐标
     * @param r 结束坐标
     */
    public static void mergeSortInternally(int[] a, int p, int r){
        // 递归终止条件
        if(p>=r) return;

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p)/2;

        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);
        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    /**
     * @desc 合并数组
     * @author sfqqyq
     * @date 2022/3/28 2:04 下午
     * @param a 原始数组
     * @param p 起始下标
     * @param q 中间下标
     * @param r 末尾下标
     */
    private static void merge(int[] a, int p, int q, int r){

        // 左边数组的最小值
        int i=p;
        // 右边数组的最小值
        int j=q+1;
        // 临时数组的下标
        int k=0;
        int[] tmp=new int[r-p+1];// 创建一个和a[p...r]一样大小的临时数组

        // 比较数据
        while (i<=q && j<=r){
            if(a[i] < a[j]){
                tmp[k++]=a[i++];
            }
            else if(a[i] == a[j]){
                tmp[k++]=a[i++];
                tmp[k++]=a[j++];
            }else {
                tmp[k++]=a[j++];
            }
        }

        // 判断，哪个数据数据不为空
        int start = i;
        int end = q;
        if(j<=r){
            start=j;
            end=r;
        }

        // 将剩余的数据插入tmp数组中
        while (start<=end){
            tmp[k++]=a[start++];
        }

        // 将tmp数组的数据插入到a数组中
        for (i = 0; i <= r-p; i++) {
            a[p+i]=tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] a=new int[]{5,6,7,2,3};
        mergeSort(a,a.length);
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+",");
        }
    }
}
