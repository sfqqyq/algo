package com.itsqq.sorts;

/**
 * @author sfqqyq
 * @date 2022年04月01日 9:58 上午
 * @desc 基数排序
 */
public class RadixSort2 {

    public static void radixSort(long[] a){
        if(a==null||a.length<=1)return;
        // 计算获取最大值
        long max=a[0];

        // 从个位开始按照指数进行排序，10，100，1000，...
        for (long exp = 1; max/exp > 0; exp*=10) {
            countingSort(a,exp);
        }
    }

    public static void countingSort(long[] a,long exp){

        // 数组从1-9所以只有10个数组
        int[] c=new int[10];
        // 统计每个数组出现的次数
        for (int i = 0; i < a.length; i++) {
            c[(int) (a[i]/exp%10)]++;
        }
        // 将c中的数据进行顺序求和
        for (int i = 1; i < c.length ; i++) {
            c[i]+=c[i-1];
        }

        // 创建临时数组
        long[] r=new long[a.length];
        // 进行计数排序// 对a进行倒序//保证稳定排序
        for (int i = a.length-1; i >=0; i--) {
            // 计算数据在r存放的下标，index是对应的r的下标
            int index=c[(int) (a[i]/exp%10)]-1;
            r[index]=a[i];
            c[(int) (a[i]/exp%10)]--;
        }

        // r和a交换数据
        for (int i = 0; i <a.length ; i++) {
            a[i]=r[i];
        }

    }


    public static void main(String[] args) {
        long[] a=new long[]{1992345891,1773032648,1883032648};
        radixSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }
}
