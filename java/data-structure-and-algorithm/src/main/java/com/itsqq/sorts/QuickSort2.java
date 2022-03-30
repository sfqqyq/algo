package com.itsqq.sorts;

/**
 * @author sfqqyq
 * @date 2022年03月30日 10:09 上午
 * @desc 快速排序实现2
 */
public class QuickSort2 {

    public static void quickSort(int[] a,int n){
        quickSortInternally(a,0,n-1);
    }

    public static void quickSortInternally(int[] a,int p,int r){
        if(p>=r)return;

        int q=partition(a,p,r);
        quickSortInternally(a,p,q-1);
        quickSortInternally(a,q+1,r);
    }

    public static int partition(int[] a,int p,int r){
        // 首选最后一个元素为分区点
        int pivot = a[r];
        int i=p;

        for (int j = p; j < r; j++) {
            if(a[j]<pivot){
                if(i==j){
                    // 如果i==j时，代表没有要交换的元素
                    i++;
                }else {
                    // 如果不相等时，需要将值和
                    int tmp=a[i];
                    a[i]=a[j];
                    a[j]=tmp;
                    i++;
                }
            }
        }
        // 将分区点和和i坐标互换
        int tmp=a[i];
        a[i]=a[r];
        a[r]=tmp;

        return i;
    }

    public static void main(String[] args) {
        int[] a=new int[]{3,4,5,1,2,8,9,4};
        quickSort(a,a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }
}
