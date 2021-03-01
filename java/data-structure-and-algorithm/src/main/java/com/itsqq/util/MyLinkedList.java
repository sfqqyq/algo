package com.itsqq.util;

import com.itsqq.domain.Node;

public class MyLinkedList<T> {
    private int size=0;
    private Node<T> first;
    private Node<T> last;

    public MyLinkedList(){
    }

    public void add(T value){
        Node<T> l=this.last;
        Node<T> newNode = new Node<>(value);
        this.last=newNode;
        if(l == null){
            this.first = newNode;
        }else {
            l.next = newNode;
        }
        this.size++;
    }

    public T get(int index){
        if(index <= this.size ){
            Node<T> node = this.first;
            for(int i=0;i<=this.size;i++){
                node = node.next;
                if(index == i){
                    return node.data;
                }
            }
        }else {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }
}
