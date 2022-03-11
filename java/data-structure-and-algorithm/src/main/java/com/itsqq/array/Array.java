package com.itsqq.array;

/**
 * @author sfqqyq
 * @date 2022年03月11日 9:10 上午
 * <p>
 * 1、数组插入、删除、按下标随机访问操作
 * 2、数组中的数据是int类型
 */
public class Array {
    // 数据数组
    private int[] data;
    // 总长度
    private int n;
    // 目前实际元素个数
    private int count;

    // 实例化、初始化数组
    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }
    // 在指定的位置插入数据
    public boolean insert(int index, int value) {
        if(index < 0 || index > count){
            System.out.println("下标异常");
            return false;
        }

        if(count >= n){
            System.out.println("数组已满");
            return false;
        }

        for(int i=count;i > index;i--){
            data[i]=data[i-1];
        }
        this.data[index]=value;
        ++count;
        return true;
    }
    // 在指定的位置插入数据
    public boolean add(int value) {
        if(count >= n) return false;
        data[count]=value;
        ++count;
        return true;
    }

    // 按照下标随机访问 时间复杂度为 O(1)
    public int find(int index) {
        if (index < 0 || index >= count) return -1;
        return this.data[index];
    }

    // 根据索引删除数组中的元素 时间复杂度为 O(n)
    public boolean delete(int index) {
        if (index < 0 || index >= count) return false;
        // 将后面的数据往前移一位
        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        // 删除数组末尾的数据
        int[] arr = new int[count - 1];
        for (int i = 0; i < count - 1; i++) {
            arr[i] = data[i];
        }
        this.data = arr;

        --count;
        return true;
    }

    // 打印所有数据
    public void printAll() {
        if (count <= 0) return;
        for (int i = 0; i < count; i++) {
            System.out.print(data[i]+",");
        }
    }

    public static void main(String[] args) {
        Array array = new Array(3);
        array.add(5);
        array.add(3);
        array.add(2);
//        array.insert(2,8);
//        array.delete(1);
        int i = array.find(2);
        System.out.println("查到的数据"+i);
        array.printAll();
    }
}
