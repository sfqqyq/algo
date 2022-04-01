package com.itsqq.sorts;

/**
 * @author sfqqyq
 * @date 2022年03月31日 5:02 下午
 * @desc 实现基数排序
 */
public class RadixSort {

    public static void radixSort(long[] a) {
        if(a==null||a.length<=1)return;
        // 计算最大值
        long max=a[0];
        for (int i = 0; i < a.length; i++) {
            if(a[i]>max)max=a[i];
        }
        for (long exp = 1; max/exp >0 ; exp*=10) {
            countingSort(a,exp);
        }
    }

    // 也就是一个计数排序
    public static void countingSort(long[] a,long exp){
        // 计算每个元素的个数,数组是0-9，只有10个
        int[] c=new int[10];
        for (int i = 0; i < a.length; i++) {
            c[(int) ((a[i]/exp)%10)]++;
        }

        // 对数组进行顺序求和
        for (int i = 1; i < c.length; i++) {
            c[i]+=c[i-1];
        }

        // 临时数组，存储排序之后的结果
        long[] r=new long[a.length];
        for (int i = a.length-1; i >=0 ; i--) {
            int index=c[(int) (a[i]/exp%10)]-1;
            r[index]=a[i];
            c[(int) (a[i]/exp%10)]--;
        }

        for (int i = 0; i < a.length; i++) {
            a[i]=r[i];
        }

    }

    public static void main(String[] args) {
        long[] a=new long[]{1992345891,1773032648};
        radixSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }


}
