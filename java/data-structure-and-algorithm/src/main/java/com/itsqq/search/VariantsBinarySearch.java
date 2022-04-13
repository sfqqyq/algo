package com.itsqq.search;

/**
 * @author sfqqyq
 * @date 2022年04月13日 10:19 上午
 * @desc 变体二分查找数据
 */
public class VariantsBinarySearch {

    // 变体一：查找第一个值等于给定值的元素
    public static int oneVarBS(int[] a,int n,int target){
        // 初始化指针数据
        int low=0,high=n-1;

        while (low<=high){
            // 计算中间值
            int mind =low+(high-low)/2;
            int mindVal=a[mind];
            if(mindVal==target){
                if(mind==0 || a[mind-1]!=target ) return mind;
                high=mind-1;
            }else if(mindVal<target){
                low=mind+1;
            }else {
                high=mind-1;
            }
        }
        return -1;
    }

    // 变体二：查找最后一个值等于给定值的元素
    public static int twoVarBS(int[] a,int n,int target){

        int low=0,high=n-1;
        while (low<=high){
            int mind = low + ((high-low) >> 1);
            if(a[mind]==target){
                if(mind==n-1 || a[mind+1] != target)return mind;
                low=mind+1;
            }else if(a[mind]<target){
                low=mind+1;
            }else {
                high=mind-1;
            }
        }
        return -1;
    }

    // 变体三：查找第一个大于等于给定值的元素
    public static int threeVarBS(int[] a,int n,int target){

        int low=0,high=n-1;
        while (low<=high){
            int mind=low+((high-low)>>1);
            if(a[mind]>target){
                // 判断第一个大于他的数
                if(mind==0 || a[mind-1]<target)return mind;
                high=mind-1;
            }else if(a[mind]==target){
                // 判断第一个等于他的数
                if(mind==0 || a[mind-1]!=target)return mind;
                high=mind-1;
            }else {
                low=mind+1;
            }
        }

        return -1;
    }

    // 变体四：查找最后一个小于等于给定值的元素
    public static int fourVarBS(int[] a,int n,int target){
        int low=0,high=n-1;
        while (low<=high){
            int mind=low+((high-low)>>1);

            if(a[mind]==target){
                if(mind==n-1 || a[mind+1]!=target)return mind;
                low=mind+1;
            }else if(a[mind]<target){
                if(mind==n-1||a[mind+1]>target)return mind;
                low=mind+1;
            }else {
                high=mind-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,2,2,3,5,6};
        int i = oneVarBS(a, a.length, 2);
        System.out.println("目标值下标i："+i);
        int i1 = twoVarBS(a, a.length, 2);
        System.out.println("目标值下标i1："+i1);
        int i2 = threeVarBS(a, a.length, 4);
        System.out.println("目标值下标i2："+i2);
        int i3 = fourVarBS(a, a.length, 2);
        System.out.println("目标值下标i3："+i3);
    }

}
