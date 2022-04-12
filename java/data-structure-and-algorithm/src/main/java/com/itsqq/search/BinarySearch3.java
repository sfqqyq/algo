package com.itsqq.search;

/**
 * @author sfqqyq
 * @date 2022年04月07日 3:41 下午
 * @desc 二分查找法
 */
public class BinarySearch3 {

    /**
     * @desc 使用递归查找
     * @author sfqqyq
     * @date 2022/4/12 10:48 上午
     * @param a 有序不重复的数组
     * @param n 数据元素个数
     * @param target 目标值
     * @return int
     */
    public int binarySearch(int[] a, int n, int target){
        int low=0,high=n-1;
        return bsearchInternally(a,low,high,target);
    }

    // 递归公式
    // 如果a[mind]==target return
    // 如果a[mind]<target f(a,low,high,target)=f(a,mind+1,high,target)
    // 如果a[mind]>target f(a,low,high,target)=f(a,low,mind-1,target)
    public int bsearchInternally(int[] a,int low,int high, int target){
        // 退出条件
        if(low>high)return -1;
        // 计算中间值
        int mind=low+(high-low)/2;

        if(a[mind]==target){
            return mind;
        }else if(a[mind]<target){
            return bsearchInternally(a,mind+1,high,target);
        }else {
            return bsearchInternally(a,low,mind-1,target);
        }
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,5};
        int i = new BinarySearch3().binarySearch(a, a.length, 9);
        System.out.println("目标值下标："+i);
    }
}
