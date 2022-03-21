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

    public static void main(String[] args) {
        // 逆序度=满有序度-有序度  满有序度：n(n-1)/2
        int[] items=new int[]{4,5,6,1,2,3};
//        Sorts.bubbleSort(items);
        Sorts.bubbleSort2(items);
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i]+",");
        }
    }
}
