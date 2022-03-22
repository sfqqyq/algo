package com.itsqq.sorts;

/**
 * @author sfqqyq
 * @date 2022年03月22日 11:22 上午
 * @desc 排序算法练习第二遍
 */
public class Sorts2 {

    // 冒泡排序
    public static void bubbleSort(int[] items){
        int n=items.length;
        // 如果只有一个元素，就不用排序
        if(n<=1)return;
        // 往上冒泡
        for (int i = 0; i < n; i++) {
            // 如果有一次遍历没有进行数据交换，那么整个数据列表都是有序的，就不需要往后面遍历
            boolean flag=false;
            // i没遍历一次，就有一个最大值冒到最上面，需要比较的数据长度就小1
            for (int j = 0; j < n-i-1; j++) {
                if(items[j]>items[j+1]){
                    // 交换
                    int tmp=items[j];
                    items[j]=items[j+1];
                    items[j+1]=tmp;
                    // 如果有交换，那么需要继续比较，如果没有交换说明元素已经有序
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

    // 插入排序
    public static void insertionSort(int[] items){
        int n=items.length;
        // 只有一个元素不用排序
        if(n<=1)return;

        // 从第二个元素开始才是未排序区，
        for (int i = 1; i < n; i++) {
            // 获取未排序区的第一个元素
            int value=items[i];
            // 排序区倒序遍历
            int j=i-1;
            for (; j >=0; j--) {
                // 找到比value值大的元素，进行移动数据给value让位
                if(items[j]>value){
                    items[j+1]=items[j];
                }else {
                    // 如果排序区最大的数据都比value小，那么value最大，不需要插入
                    break;
                }
            }
            // 在比value小的元素的后一位插入value元素
            items[j+1]=value;
        }
    }

    // 选择排序
    // 两个区域，已排序的区域，未排序的区域
    // 在未排序中选一个最小的一个元素与未排序的首元素进行交换位置，已排序元素个数加1
    public static void selectionSorts(int[] items){
        int n=items.length;
        if(n<=1)return;
        for (int i = 0; i < n-1; i++) {
            int minIndex=i;
            for (int j = i+1; j < n; j++) {
                if(items[j]<items[minIndex]){
                    minIndex=j;
                }
            }
            if(minIndex==i)continue;
            int tmp=items[i];
            items[i]=items[minIndex];
            items[minIndex]=tmp;
        }



    }


    public static void main(String[] args) {
        int[] items=new int[]{5,6,7,1,2,3,4};
        // 冒泡排序
//        Sorts2.bubbleSort(items);
        // 插入排序
//        Sorts2.insertionSort(items);
        // 选择排序
        Sorts2.selectionSorts(items);
        for (int item : items) {
            System.out.print(item+",");
        }
    }


}
