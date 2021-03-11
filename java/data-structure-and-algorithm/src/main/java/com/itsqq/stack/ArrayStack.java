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
    private int n=3;  //栈的大小

    public ArrayStack(){
        items=new String[this.n];
        this.count=0;
    }

    /**
     * 入栈
     * @param value 入栈的值
     */
    public void push(String value){
        if(count >= n){
            // 数组扩容
            this.dilatation();
        }
        items[count]=value;
        count++;
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
     * 扩容数组
     */
    private void dilatation(){
        // 扩充2倍
        this.n=this.n*2;
        String[] item = new String[this.n];
        System.arraycopy(this.items, 0, item, 0, this.items.length);
        this.items=item;
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
