package com.itsqq.domain;

/**
 * 链表节点
 */
public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data){
        this.data=data;
    }
    public Node(){
    }
}
