package com.itsqq.sorts;

/**
 * @author sfqqyq
 * @date 2022年03月30日 3:26 下午
 * @desc 寻找第k大元素
 */
public class KthSmallest {

    public static int kthSmallest(int[] a,int n,int k){
        if(a==null||a.length<k)return -1;
        // 计算分区点
        int q=partition(a,0,a.length-1);
        while (q+1!=k){
            if(q+1<k){
                // 将在右边数据里继续寻找
                q=partition(a,q+1,a.length-1);
            }else {
                // 在左边边数据中继续寻找
                q=partition(a,0,q-1);
            }
        }
        return a[q];
    }

    // 分区函数，计算分区点的下标
    public static int partition(int[] a,int p,int r){

        int i=p;
        int pivot=a[r];
        for (int j = p; j < r; j++) {
            if(a[j]<pivot){
                if(i==j) {
                    i++;
                }else {
                    // 交换数据
                    int tmp=a[i];
                    a[i]=a[j];
                    a[j]=tmp;
                    i++;
                }
            }
        }
        // 分区点和i进行交换位置
        int tmp=a[r];
        a[r]=a[i];
        a[i]=tmp;

        return i;
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,2,3};
        int i1 = kthSmallest(a, a.length, 2);
        System.out.println(i1);
    }

}
