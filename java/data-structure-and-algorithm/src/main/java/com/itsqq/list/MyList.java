package com.itsqq.list;

import com.itsqq.domain.Node;

/**
 * 创建一个单链表
 */
public class MyList<T> {
    // 头节点
    private Node<T> head = new Node<>(null);
    // 大小
    private int size = 0;

    public MyList() {
    }

    public MyList(T value) {
        this.head = new Node<>(value);
    }

    /**
     * 添加节点
     *
     * @param value 输入的值
     */
    public void add(T value) {
        Node<T> temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<>(value);
        this.size++;
    }

    /**
     * 在指定的位置插入节点
     *
     * @param index 索引
     * @param value 值
     */
    public void add(int index,T value){
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("下标越界！");
        }
        Node<T> temp=this.head;
        int counter=-1;
        while (temp!=null){
            if(counter == index){
                Node<T> next = temp.next;
                temp.next=new Node<>(value);
                temp.next.next=next;
            }
            temp=temp.next;
            counter++;
        }
        size++;
    }



    /**
     * 通过索引获取值
     * @param index 索引
     * @return 返回节点值
     */
    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("下标越界！");
        }
        // head只是一个标志，并不是链表中的节点
        Node<T> temp = this.head;
        // 由于head不属于节点，所以counter从-1开始计数。
        int counter = -1;
        while (temp != null) {
            if (counter == index) {
                return temp.data;
            }
            temp = temp.next;
            counter++;
        }
        return null;
    }

    /**
     * 链表大小
     *
     * @return 返回链表大小
     */
    public int size() {
        return this.size;
    }

    /**
     * 打印链表
     */
    public void printfList() {
        Node<T> temp = this.head;
        while (temp.next != null) {
            System.out.print(temp.next.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


}
