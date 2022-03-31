package com.itsqq.sorts;

/**
 * @author sfqqyq
 * @date 2022年03月31日 1:49 下午
 * @desc 桶排序实现2
 */
public class BucketSort2 {

    /**
     * @param a          数组
     * @param bucketSize 桶大小
     * @desc 桶排序
     * @author sfqqyq
     * @date 2022/3/31 1:51 下午
     */
    public static void bucketSort(int[] a, int bucketSize) {

        if (a == null || a.length <= 1) return;

        // 获取最大最小值
        int minValue = a[0];
        int maxValue = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < minValue) {
                minValue = a[i];
            } else if (a[i] > maxValue) {
                maxValue = a[i];
            }
        }

        // 计算桶的数量
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        // 初始化桶
        int[][] buckets = new int[bucketCount][bucketSize];
        // 记录每个桶中有多少个数据
        int[] indexArr = new int[bucketCount];

        // 将数据存放在桶中
        for (int i = 0; i < a.length; i++) {
            // 计算该元素属于哪个桶
            int bucketIndex = (a[i] - minValue) / bucketSize;
            if (indexArr[bucketIndex] >= bucketSize) {
                // 扩容
                ensureCapacity(buckets, bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = a[i];
        }

        // 对每个桶中的数据进行排序
        int k = 0;
        for (int i = 0; i < bucketCount; i++) {
            // 如果桶中没有数据不排序
            if (indexArr[i] == 0) continue;
            // 用快速排序对桶中数据进行排序
            quickSort(buckets[i], 0, indexArr[i] - 1);

            // 将排完序后的数据重新写回原数组中
            for (int j = 0; j < indexArr[i]; j++) {
                a[k++] = buckets[i][j];
            }
        }
    }

    /**
     * @param buckets     所有桶
     * @param bucketIndex 第几个桶的指引
     * @desc 对容积不够的桶进行扩容
     * @author sfqqyq
     * @date 2022/3/31 2:22 下午
     */
    public static void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tmp = new int[buckets[bucketIndex].length * 2];
        for (int i = 0; i < buckets[bucketIndex].length; i++) {
            tmp[i] = buckets[bucketIndex][i];
        }
        buckets[bucketIndex] = tmp;
    }

    /**
     * @param a 数组
     * @param p 首下标
     * @param r 尾下标
     * @desc 快速排序
     * @author sfqqyq
     * @date 2022/3/31 1:51 下午
     */
    public static void quickSort(int[] a, int p, int r) {
        if (p >= r) return;

        // 计算分区点
        int pivot = partition(a, p, r);

        quickSort(a, p, pivot - 1);
        quickSort(a, pivot + 1, r);
    }

    /**
     * @param a 数组
     * @param p 首下标
     * @param r 未下标
     * @return int 分区结点下标
     * @desc 分区函数
     * @author sfqqyq
     * @date 2022/3/31 2:24 下午
     */
    public static int partition(int[] a, int p, int r) {

        int i = p;
        int pivot = a[r];
        for (int j = 0; j < r; j++) {
            if(a[j]<pivot){
                if(i==j){
                    i++;
                }else {
                    swap(a,i,j);
                    i++;
                }
            }
        }
        swap(a,i,r);
        return i;
    }

    /**
     * @desc 数据交换
     * @author sfqqyq
     * @date 2022/3/31 2:40 下午
     * @param a 数组
     * @param i 下标
     * @param j  下标
     */
    public static void swap(int[] a,int i,int j){
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }


    public static void main(String[] args) {
        int[] a=new int[]{3,4,5,1,2,8,9,4};
        bucketSort(a,3);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }
}
