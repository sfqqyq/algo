package com.itsqq.sorts;

/**
 * @author sfqqyq
 * @date 2022年03月31日 11:13 上午
 * @desc 桶排序实现
 */
public class BucketSort {

    /**
     * @desc 桶排序
     * @author sfqqyq
     * @date 2022/3/31 1:22 下午
     * @param a 数组
     * @param bucketSize 桶容量
     */
    public static void bucketSort(int[] a,int bucketSize){
        if(a==null||a.length<=1)return;

        // 取最大值
        int minValue=a[0];
        int maxValue=a[1];
        for (int i = 0; i < a.length; i++) {
            if(a[i]<minValue){
                minValue=a[i];
            }else if(a[i]>maxValue){
                maxValue=a[i];
            }
        }

        // 桶数量
        int bucketCount= (maxValue-minValue)/bucketSize+1;
        // 创建桶
        int[][] buckets=new int[bucketCount][bucketSize];
        // 统计每个桶里面有多少数据
        int[] indexArr = new int[bucketCount];
        // 将数据放入桶中
        for (int i = 0; i <a.length; i++) {
            // 计算该数据属于哪一个桶
           int bucketIndex= (a[i]-minValue) / bucketSize;
            if(indexArr[bucketIndex]>=buckets[bucketIndex].length){
                // 扩容
                ensureCapacity(buckets,bucketIndex);
            }
           buckets[bucketIndex][indexArr[bucketIndex]++]=a[i];
        }

        // 对桶内数据进行排序，使用快速排序

        int k=0;
        for (int i = 0; i < bucketCount; i++) {
            if(indexArr[i]==0)continue;

            // 进行快速排序
            quickSort(buckets[i],0,indexArr[i]-1);
            for (int j = 0; j < indexArr[i]; j++) {
                a[k++]=buckets[i][j];
            }
        }

    }

    /**
     * 数组扩容
     *
     * @param buckets
     * @param bucketIndex
     */
    private static void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }

    /**
     * @desc 快速排序
     * @author sfqqyq
     * @date 2022/3/31 11:27 上午
     * @param a 数组
     * @param p 起始下标
     * @param r 末尾下标
     */
    public static void quickSort(int[] a,int p,int r){
        if(p>=r)return;

        // 计算分区点
        int pivot=partition(a,p,r);
        quickSort(a,p,pivot-1);
        quickSort(a,pivot+1,r);
    }

    /**
     * @desc 分区函数
     * @author sfqqyq
     * @date 2022/3/31 1:10 下午
     * @param a 数组
     * @param p 首下标
     * @param r 尾下标
     * @return int 返回分区点下标
     */
    public static int partition(int[] a,int p,int r){

        int i=p;
        int pivot=a[r];
        for (int j = p; j < r; j++) {
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
     * @desc 数组内交换数据
     * @author sfqqyq
     * @date 2022/3/31 11:15 上午
     * @param a 数组
     * @param i 下标
     * @param j 下标
     */
    public static void swap(int[] a,int i,int j){
        if(a==null || i>=a.length||j>=a.length)return;

        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
}
