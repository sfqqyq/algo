package com.itsqq.stack;

/**
 * @author sfqqyq
 * @date 2022年03月17日 1:07 下午
 * @desc 基于数组的栈的实现 (顺序栈)
 */
public class ArrayStack {
    private String[] items; // 数组
    private int count; // 栈中元素个数
    private int n; //栈的大小
    // 初始化数组，申请一个大小为n的数组空间
    public ArrayStack(int n) {
        this.items=new String[n];
        this.n=n;
        this.count=0;
    }
    // 入栈操作
    public boolean push(String item) {
        // 数组满了
        if(count>=n){
            // TODO 可以扩容
            return false;
        }
        items[count]=item;
        count++;
        return true;
    }
    // 出栈操作
    public String pop() {
        if(count==0)return null;
        String item = items[--count];
        items[count]=null;
        return item;
    }
    // 获取栈元素
    public int getSize(){
        return this.count;
    }
    // 打印所有的元素
    public void printAll(){
        if(items==null){return;}
        for (int i = 0; i < count; i++) {
            System.out.print(items[i]+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push("10");
        stack.push("11");
        stack.push("12");
        stack.printAll();
        System.out.println("size:"+stack.getSize());
        stack.pop();
//        stack.pop();
        stack.printAll();
        System.out.println("size:"+stack.getSize());
        stack.push("15");
        stack.printAll();
        System.out.println("size:"+stack.getSize());
    }


}
