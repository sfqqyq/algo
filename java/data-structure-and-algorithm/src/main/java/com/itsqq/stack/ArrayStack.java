package com.itsqq.stack;

/**
 * 使用数组实现栈
 *
 * @author sfqqyq
 * @createDate 20210303
 * @desc java 实现顺序栈
 */
public class ArrayStack {

    private String[] items; // 数组
    private int count; //栈的元素个数
    private int n;  //栈的大小

    public ArrayStack(int n){
        items=new String[n];
        this.n=n;
        this.count=0;
    }

    /**
     * 入栈
     * @param value 入栈的值
     */
    public boolean push(String value){
        if(count >= n){
            // 返回false，入栈失败
            return false;
        }
        items[count]=value;
        count++;
        // 返回true，入栈成功
        return true;
    }

    /**
     * 出栈
     * @return 出栈的元素
     */
    public String pop(){
        if(count == 0){
            return null;
        }
        String item = items[count-1];
        count--;
        return item;
    }

    /**
     * 打印顺序栈
     */
    public void printfArrayStack(){
        for (int i=0;i<count;i++) {
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }

}
