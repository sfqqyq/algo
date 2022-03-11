package com.itsqq.array;

/**
 * @author sfqqyq
 * @date 2022年03月11日 10:21 上午
 * <p> 第二遍练习数组
 * 1、实现数组的新增、插入、删除、按下标随机访问功能
 * 2、数组中的数据是 int 类型
 */
public class Array2 {

    private int[] data; // 数据
    private final int capacity; // 容量
    private int length; // 长度

    // 初始化容量
    public Array2(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        this.length = 0;
    }

    // 添加一个元素
    public boolean add(int value) {
        if (this.length >= this.capacity) {
            System.err.println("警告：数组容量已满。。。");
            return false;
        }
        this.data[length] = value;
        ++this.length;
        return true;
    }

    // 插入数据
    public boolean insert(int index, int value) {
        if (index < 0 || index > this.length) {
            System.err.println("警告：下标错误。。。");
            return false;
        }
        if (this.length >= this.capacity) {
            System.err.println("警告：数组容量已满。。。");
            return false;
        }
        // 将 index 位置的数据依次往后移一位
        for (int i = this.length; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = value;
        ++this.length;
        return true;
    }

    // 删除一个元素
    public boolean delete(int index) {
        if (index < 0 || index >= this.length) {
            System.err.println("警告：下标错误。。。");
            return false;
        }
        // 将索引index后的元素往前移一位
        for (int i = index + 1; i < this.length; i++) {
            this.data[i - 1] = this.data[i];
        }
        // 删除最后一个元素，将数据放在一个新的数组中，将data引用地址指向新的数组
        int[] arr = new int[this.capacity];
        for (int i = 0; i < length - 1; i++) {
            arr[i] = this.data[i];
        }
        this.data = arr;
        --this.length;
        return true;
    }

    // 按照索引随机查找数据
    public int find(int index) {
        if (index < 0 || index >= this.length) {
            System.err.println("警告：下标错误。。。");
            return -1;
        }
        return this.data[index];
    }

    // 打印数组中的数据
    public void printAll() {
        if (this.length <= 0) {
            System.err.println("提示：数组为空。。。");
            return;
        }
        for (int i = 0; i < this.length; i++) {
            System.out.print(this.data[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array2 array2 = new Array2(5);
//        array2.printAll();
        array2.insert(0, 3);
        array2.insert(0, 4);
        array2.insert(1, 5);
        array2.insert(3, 9);
        array2.insert(3, 10);
        //array.insert(3, 11);
        array2.printAll();
        array2.delete(2);
        array2.printAll();
        int i = array2.find(2);
        System.out.println("查找到的数据：" + i);
        array2.add(11);
        array2.printAll();

    }

}
