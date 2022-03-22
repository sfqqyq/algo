package com.itsqq.sorts;

/**
 * @author sfqqyq
 * @date 2022年03月21日 2:48 下午
 * @desc 冒泡排序、插入排序、选择排序
 */
public class Sorts {

    // 冒泡排序练习1
    public static void bubbleSort(int[] items){
        if(items.length<=1)return;
        boolean flag;// 提前退出冒泡标志
        for (int i = 0; i < items.length; i++) {
            flag=false;
            for (int j = 0; j < items.length -i-1; j++) {
                if(items[j]>items[j+1]){
                    // 交换
                    int tmp=items[j+1];
                    items[j+1]=items[j];
                    items[j]=tmp;
                    flag=true;
                }
            }
            // 如果没有数据交换就退出
            if(!flag){
                break;
            }
        }
    }

    // 冒泡排序练习2 时间复杂度，最好是O(n) 最坏是O(n^2),平均是n(n-1)/4 = O(n^2)
    public static void bubbleSort2(int[] items){
        // 元素个数
        int n=items.length;
        // 元素个数小于等于1 ，不需要排序
        if(n<=1)return;
        for (int i = 0; i < n; i++) {
            boolean flag=false;
            for (int j = 0; j < n-i-1; j++) {
                // 比较大小
                if(items[j]>items[j+1]) {
                    int tmp = items[j + 1];
                    items[j + 1] = items[j];
                    items[j] = tmp;
                    // 有需要交换的元素
                    flag = true;
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
        if(n<=1)return;
        for (int i = 1; i < n; i++) {
            int value=items[i];
            int j = i-1;
            for (;j >=0; j--) {
               if(items[j]>value){
                items[j+1]=items[j];
               } else {
                   break;
               }
            }
            items[j+1]=value;
        }
    }
    // 插入排序练习2
    public static void insertionSort2(int[] items){
        int n=items.length;
        if(n<=1)return;
        // 以第二个元素为起始
        for (int i = 1; i <n ; i++) {
            int value=items[i];
            // j从第一个元素开始
            int j = i-1;
            for (; j >=0 ; j--) {
                // 从排过序部分倒叙比较，直至找到比items[i]值小的数据，
                // 将value值赋值给items[j+1],j为比items[i]小的数据的下标，
                // 所以是要放在j的后面的一个数据位
                if(items[j]>value){
                    items[j+1]=items[j];
                }else {
                    break;
                }
            }
            items[j+1]=value;
        }
    }

    // 选择排序 最好，最坏，平均时间复杂度都是O(n^2)
    // 是原地排序算法
    // 不是稳定的排序算法
    public static void selectionSorts(int[] items){
        int n=items.length;
        if (n<=1)return;

        for (int i = 0; i < n-1; i++) {
            int minIndex=i;
            for (int j = i+1; j <n; j++) {
                if(items[minIndex]>items[j]){
                    minIndex=j;
                }
            }
            int tmp=items[i];
            items[i]=items[minIndex];
            items[minIndex]=tmp;
        }
    }

    public static void main(String[] args) {
        // 逆序度=满有序度-有序度  满有序度：n(n-1)/2
//        int[] items=new int[]{4,5,6,1,2,3};
        int[] items=new int[1000000];
        for (int i = 1000000,j=0; i > 0; i--,j++) {
            items[j]=i;
        }
        long l = System.currentTimeMillis();
        Sorts.bubbleSort(items);
        long e = System.currentTimeMillis();
        System.out.println("冒泡需要时间："+(e-l)+"ms");

        for (int i = 1000000,j=0; i > 0; i--,j++) {
            items[j]=i;
        }
//        Sorts.bubbleSort2(items);
        l = System.currentTimeMillis();
        Sorts.insertionSort2(items);
        e = System.currentTimeMillis();
        System.out.println("插入需要时间："+(e-l)+"ms");

        for (int i = 1000000,j=0; i > 0; i--,j++) {
            items[j]=i;
        }
        l = System.currentTimeMillis();
        Sorts.selectionSorts(items);
        e = System.currentTimeMillis();
        System.out.println("插入需要时间："+(e-l)+"ms");

        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i]+",");
        }
    }
}
