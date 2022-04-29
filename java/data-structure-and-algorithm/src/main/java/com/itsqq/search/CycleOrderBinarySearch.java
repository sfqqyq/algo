package com.itsqq.search;

/**
 * @author sfqqyq
 * @date 2022年04月13日 2:30 下午
 * @desc 循环有序数组
 */
public class CycleOrderBinarySearch {

    public int cycleOrderBS(int[] a, int n, int target){


        int i = searchRecursion(a, 0, n - 1, target);
        return i;

    }

//    public static void main(String[] args) {
//        int[] a=new int[]{3,4,5,6,1,2};
//        int i = new CycleOrderBinarySearch().cycleOrderBS(a, a.length, 6);
//        System.out.println("目标值下标："+i);
//    }

    /**
     * @desc 二分查找法变体
     * @author sfqqyq
     * @date 2022/4/13 3:52 下午
     * @desc
       首先使用二分查找法找到最大值，在分成两个数组，判断范围进行查找
     * @param target 目标值
     */
    public int searchRecursion(int[] a, int low, int high,int target){


return -1;

    }

    /**
     * @desc 使用二分法查找循环有数组最大值,先分割在合并
     * @param a 数组
     * @param low 最小下标
     * @param high 最大下标
     * @return 返回下标值
     */
    public static int searchMaxValue(int[] a,int low,int high){

        if(high-low<=1) return a[high]>=a[low] ? high : low;

        // 计算中值
        int min=low+(high-low)/2;

        // 计算左边最大值
        int left = searchMaxValue(a,low,min);
        // 计算右边最大值
        int right = searchMaxValue(a,min+1,high);

        // 在合并数据
        return a[left]>=a[right] ? left : right;
    }

    public static void main(String[] args) {
        int[] a=new int[]{6,5,3,9};
        int i = searchMaxValue(a, 0, a.length-1);
        System.out.println("目标值下标："+i);
    }

}
