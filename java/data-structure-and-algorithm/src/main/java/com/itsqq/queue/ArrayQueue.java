package com.itsqq.queue;

/**
 * @author sfqqyq
 * @date 2022年03月18日 4:37 下午
 * @desc 基于数组的队列实现 顺序队列
 */
public class ArrayQueue<T> {
    // 数组
    private T[] items;
    // 数组大小
    private int n;
    // 头下标
    private int head;
    // 尾下标
    private int tail;
    // 初始化顺组队列
    public ArrayQueue(int n){
        this.n=n;
        this.items=(T[])new Object[this.n];
        this.head=0;
        this.tail=0;
    }

    // 入栈
    public boolean enqueue(T item){
//        if(this.head>this.tail)return false;
        if(tail>=n){ // 数据搬移
            // TODO 需要扩容或阻塞或拒绝
            dataMovement(); // 数据搬移
        }
        this.items[tail++]=item;
        return true;
    }

    private void dataMovement() {
        // 数组满了，
        if((tail-head)>=n){
//            this.n=n*2;
//            T[] tmpArr=(T[])new Object[this.n*2];
//            for (int i=0;i<tail;i++){
//                tmpArr[i]=this.items[i];
//            }
//            this.items=tmpArr;
            throw new RuntimeException("队列满了。。。");
        }else {
            for (int i = 0,j=head; j < tail; i++,j++) {
                this.items[i]=this.items[j];
            }
        }

    }

    // 出栈
    public T dequeue(){
        // 队列没数据
        if(this.items==null || this.head>=this.tail)return null;
        // 获取数据
        return this.items[head++];
    }

    // 打印栈数据
    public void printAll(){
        if(this.items==null)return;
        for (int i=head;i<tail;i++){
            System.out.print(items[i]+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>(5);
        queue.enqueue("10");
        queue.enqueue("11");
        queue.enqueue("12");
        queue.enqueue("13");
        queue.enqueue("14");
        queue.enqueue("15");
        queue.printAll();
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        queue.printAll();
//        queue.enqueue("13");
//        queue.enqueue("14");
//        queue.printAll();
    }

}
