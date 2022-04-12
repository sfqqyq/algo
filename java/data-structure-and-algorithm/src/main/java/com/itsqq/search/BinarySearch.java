package com.itsqq.search;

/**
 * @author sfqqyq
 * @date 2022年04月07日 3:41 下午
 * @desc 二分查找法
 */
public class BinarySearch {

    /**
     * @desc 二分查找
     * @author sfqqyq
     * @date 2022/4/12 10:27 上午
     * @param a 数组 有序 不重复
     * @param n 数组元素个数
     * @param target 目标元素
     */
    public static int binarySearch(int[] a, int n,int target){

        // 初始化下标
        int low=0,high=n-1;

        // 退出条件（目标值的范围已经超过了该有序算法的最大值或最小值）
        while (low<=high){
            // 计算中间下标值(防止r+p超过int最大值)
            int mid=low+(high-low)/2;
            if(a[mid]==target){
                return mid;
            }else if(a[mid]<target){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,5};
        int i = binarySearch(a, a.length, 4);
        System.out.println("目标值下标："+i);
    }
}
