package com.itsqq.queue;

/**
 * @author sfqqyq
 * @date 2022年03月19日 4:34 下午
 * @desc 循环队列 ，解决顺序队列数据搬移问题
 */
public class CircularQueue {
    // 队列容器
    private int[] items;
    // 队列总长度
    private int n;
    // 头指针
    private int head;
    // 尾指针
    private int tail;

    public CircularQueue(int n){
       this.items=new int[n];
       this.n=n;
       head=0;
       tail=0;
    }

    // 入队
    public boolean enqueue(int data){
        // 判断容器是不是满了
        if((tail+1)%n==head){// 满了
            return false;
        }
        items[tail++]=data;
        if(tail>=n){
            tail=0;
        }
        return true;
    }

    // 出队
    public int dequeue(){
        // 空的
        if(this.items==null || head==tail){
            return -1;
        }
        int item = items[head++];
        head = head>=n ? 0 : head;
        return item;
    }
    // 打印所有数据
    public void printAll(){
        if(this.items==null || head==tail){
            return;
        }
        int i;
        for (i=head; i<n && i!=tail ;i++){
            System.out.print(items[i]+",");
        }
        if(i==n){
            for (int j=0;j<=tail;j++){
                System.out.print(items[j]+",");
            }
        }
        System.out.println();
//        else {
//            System.out.println(items[tail]);
//        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(10);
        queue.enqueue(11);
        queue.enqueue(12);
        //queue.enqueue(13);
        //queue.enqueue(14);// 由于循环列表会浪费一个内存空间，所以只有四个空间
        queue.printAll();
        queue.dequeue();
        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
        queue.printAll();
    }
}
