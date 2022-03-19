package com.itsqq.queue;

/**
 * @author sfqqyq
 * @date 2022年03月19日 4:07 下午
 * @desc 基于链表实现是队列，链式队列
 */
public class QueueBaseOnLinkedList<T> {

    // 队列的队首和队尾
    private Node<T> head = null;
    private Node<T> tail = null;

    public QueueBaseOnLinkedList(){
        head=null;
        tail=null;
    }

    // 入队
    public boolean enqueue(T data){
       if(tail==null){
           tail=new Node(data,null);
           head=tail;
           return true;
       }
       tail.next=new Node(data,null);
       tail=tail.next;
       return true;
    }

    // 出队
    public T dequeue(){
        if(head==null){return null;}
        T data = head.data;
        head=head.next;
        return data;
    }

    public void printAll(){
        if(head==null)return;
        Node<T> tmpN=this.head;
        while (tmpN!=null){
            System.out.print(tmpN.data+",");
            tmpN=tmpN.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueBaseOnLinkedList<Object> queue = new QueueBaseOnLinkedList<>();
        queue.enqueue("10");
        queue.enqueue("11");
        queue.enqueue("12");
        queue.printAll();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printAll();
    }





}


class Node<T>{
    public T data;
    public Node<T> next;
    public Node(T data,Node<T> next){
        this.data=data;
        this.next=next;
    }
}
