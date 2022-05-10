package com.itsqq.search;

/**
 * @author sfqqyq
 * @date 2022年04月13日 2:30 下午
 * @desc 循环有序数组
 */
public class CycleOrderBinarySearch {

    public static int cycleOrderBS(int[] a, int n, int target){

        int maxIndex = searchMaxIndex(a, 0, n - 1);

        return a[0]<=target&&a[maxIndex]>=target ?
                searchRecursion(a, 0, maxIndex, target) :
                searchRecursion(a,maxIndex+1,n-1,target);
    }

    /**
     * @desc 首先使用二分查找法找到最大值，在分成两个数组，判断范围进行查找
     * @author sfqqyq
     * @date 2022/4/13 3:52 下午
     * @param target 目标值
     */
    public static int searchRecursion(int[] a, int low, int high,int target){

        // 退出条件
        if(low>high)return -1;

        int min=low+(high-low)/2;

        if(target==a[min]){
            return min;
        }else if(target>a[min]){
            return searchRecursion(a,min+1,high,target);
        }else {
            return searchRecursion(a,low,min-1,target);
        }

    }

    /**
     * @desc 使用先分割在合并
     * @param a 数组
     * @param low 最小下标
     * @param high 最大下标
     * @return 返回下标值
     */
    public static int searchMaxIndex(int[] a,int low,int high){

        if(high-low<=1) return a[high]>=a[low] ? high : low;

        // 计算中值
        int min=low+(high-low)/2;

        // 计算左边最大值
        int left = searchMaxIndex(a,low,min);
        // 计算右边最大值
        int right = searchMaxIndex(a,min+1,high);

        // 在合并数据
        return a[left]>=a[right] ? left : right;
    }

    public static void main(String[] args) {
        int[] a=new int[]{3,4,5,6,1,2};
        int i = cycleOrderBS(a, a.length, 61);
        System.out.println("目标值下标："+i);
    }

}
