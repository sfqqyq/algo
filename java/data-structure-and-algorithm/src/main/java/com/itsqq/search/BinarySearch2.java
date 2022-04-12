package com.itsqq.search;

/**
 * @author sfqqyq
 * @date 2022年04月07日 3:41 下午
 * @desc 二分查找法
 */
public class BinarySearch2 {

    /**
     * @desc 循环实现二分查找法
     * @author sfqqyq
     * @date 2022/4/12 10:43 上午
     * @param a 有序不重复的数组
     * @param n 数据元素个数
     * @param target 目标值
     * @return int
     */
    public static int binarySearch(int[] a, int n,int target){
        // 初始化下标
        int low=0,high=n-1;
        // 退出条件
        while (low<=high){
            // 计算中间坐标值
            int mind=low+(high-low)/2;
            if(a[mind]==target){
                return mind;
            }else if(a[mind]<target){
                low=mind+1;
            }else {
                high=mind-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,5};
        int i = binarySearch(a, a.length, 1);
        System.out.println("目标值下标："+i);
    }
}
