package com.itsqq.sorts;

/**
 * @author sfqqyq
 * @date 2022年03月30日 9:51 上午
 * @desc 快速排序实现
 */
public class QuickSort {

    // 快速排序，a是数组，n是数组大小
    public static void quickSort(int[] a,int n){
        quickSortInternally(a,0,n-1);
    }

    // 快速排序递归函数，p,r为下标
    public static void quickSortInternally(int[] a,int p,int r){
        // 递归结束条件
        if(p>=r)return;

        // 获取分区点
        int q=partition(a,p,r);
        quickSortInternally(a,p,q-1);
        quickSortInternally(a,q+1,r);

    }
    // 分区函数 获取分区点，是不是原地排序，全靠这个函数
    public static int partition(int[] a,int p,int r){
        // 将最右面的数据作为分区点
        int pivot = a[r];
        // i 作为选择排序的思想，将数据分为已排序区和未排序区
        int i=p;
        for (int j=p;j<r;j++){
            if(a[j]<pivot){
                if(i==j){
                    i++;
                }else {
                    int tmp=a[i];
                    a[i++]=a[j];
                    a[j]=tmp;
                }
            }
        }
        // 将分区点和i位置为数据进行调换
        int tmp=a[i];
        a[i]=a[r];
        a[r]=tmp;
        // 返回分区点
        return i;
    }

}
