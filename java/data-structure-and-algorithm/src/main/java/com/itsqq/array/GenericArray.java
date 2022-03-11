package com.itsqq.array;

import java.util.Objects;

/**
 * @author sfqqyq
 * @date 2022年03月11日 1:12 下午
 *
 * 1、通用数据对象
 * 2、实现一个支持动态扩容的数组
 * 3、实现两个有序数组合并为一个有序数组
 */
public class GenericArray<T> {
    // 数据
    private T[] data;
    // 元素个数
    private int size;

    // 根据传入容量，构造Array
    public GenericArray(int capacity){
        this.data=(T[]) new Objects[capacity];
        this.size=0;
    }
    // 无参构造方法，默认数组容量为10
    public GenericArray(){
        this.data= (T[]) new Objects[10];
        this.size=0;
    }
    // 获取数组容量
    public int getCapacity(){
        return this.data.length;
    }
    // 获取当前元素个数
    public int getSize(){
        return this.size;
    }
    // 判断数组是否为空
    public boolean isEmpty(){
        return this.size == 0;
    }
    // 修改 index 位置的元素
    public boolean update(int index , T e){
        checkIndex(index);
        this.data[index]=e;
        return true;
    }
    // 获取对应 index 位置的元素
    public T findEbyIndex(int index){
        checkIndex(index);
        return this.data[index];
    }
    // 查看数组是否包含元素e
    public boolean contains(T e){
        for (int i = 0; i < getSize(); i++) {
            // equals 比较值是否相等 == :比较地址和值是否相等
            if(this.data[i].equals(e)){
                return true;
            }
        }
        return false;
    }
    // 获取对应元素的下标, 未找到，返回 -1
    public int findIndex(T e){
        for (int i = 0; i < getSize(); i++) {
            // equals 比较值是否相等 == :比较地址和值是否相等
            if(this.data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
    // 在 index 位置，插入元素e, 时间复杂度 O(m+n)
    public boolean insert(int index , T e){
        checkIndexOfAdd(index);
        // 如果满了就扩容
        if(getSize()>=getCapacity()) expansion(2*getCapacity());

        for (int i=getSize();i>index;i--){
            this.data[i]=this.data[i-1];
        }
        this.data[index]=e;
        this.size++;
        return true;
    }
    // 向数组头插入元素
    public boolean addFirst(T e){
        return insert(0, e);
    }
    // 向数组尾插入元素
    public boolean addLast(T e){
        return insert(getSize()-1, e);
    }
    // 删除 index 位置的元素，并返回
    public T deleteByIndex(int index){
        checkIndex(index);
        T ebyIndex = findEbyIndex(index);
        for (int i = index+1; i < getSize(); i++) {
            this.data[i-1]=this.data[i];
        }
        // 可以删除最后一个元素也可以不删除
        this.size--;
        this.data[size]=null;
        // 缩容 数据总数是数组容量的1/4,保留初始的长度大小
        if(size==data.length/4&&data.length/2!=0){
            expansion(data.length/2);
        }
        return ebyIndex;

    }
    // 删除第一个元素
    public T deleteFirst(){
        return deleteByIndex(0);
    }
    // 删除末尾元素
    public T deleteLast(){
        return deleteByIndex(getSize()-1);
    }
    // 从数组中删除指定元素 时间复杂度O(n)
    public void deleteE(T e){
        int index = findIndex(e);
        if(index!=-1){
            deleteByIndex(index);
        }
    }
    // 扩容方法，时间复杂度 O(n)
    public void expansion(/*扩容容量*/int capacity){
        T[] newData=(T[])new Objects[capacity];

        for (int i=0;i<getSize();i++){
            newData[i]=this.data[i];
        }

        this.data=newData;
    }
    // 检查索引是否合法
    public void checkIndex(int index){
        if(index<0 || index>=getSize()){
            throw new IllegalArgumentException("索引不合法。。。");
        }
    }
    // 检查索引在新增中是否合法
    public void checkIndexOfAdd(int index){
        checkIndex(index);
        if(index>=getCapacity()){
            throw new IllegalArgumentException("索引超过数组容量值。。。");
        }
    }

    //实现两个有序数组合并为一个有序数组O(m+n)
    public static int[] mergeArr(/*有序数组*/int[] arr1,/*有序数组*/int[] arr2){
        int arr1Index=0;
        int arr2Index=0;
        int resIndex=0;
        int[] res=new int[arr1.length+arr2.length];

        while (true){
            if(arr1Index>=arr1.length){
                // 将2存到res中
                for (;arr2Index<arr2.length;arr2Index++,resIndex++){
                    res[resIndex]=arr2[arr2Index];
                }
                break;
            }
            if(arr2Index>=arr2.length){
                // 将1存到res中
                for (;arr1Index<arr1.length;arr1Index++,resIndex++){
                    res[resIndex]=arr1[arr1Index];
                }
                break;
            }
            int t1 = arr1[arr1Index];
            int t2 = arr2[arr2Index];
            if(t1>t2){
                res[resIndex++]=t2;
                arr2Index++;
            }else if(t1<t2){
                res[resIndex++]=t1;
                arr1Index++;
            }else if(t1==t2){
                res[resIndex++]=t1;
                arr1Index++;
                res[resIndex++]=t2;
                arr2Index++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arrM = new int[]{8,10,12,17,18};
        int[] arrN = new int[]{2,3,5,9,11};
        int[] ints = GenericArray.mergeArr(arrM, arrN);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }
    }
}
