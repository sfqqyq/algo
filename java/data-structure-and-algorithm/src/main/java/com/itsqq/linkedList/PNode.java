package com.itsqq.linkedList;

/**
 * @author sfqqyq
 * @date 2022年03月16日 3:00 下午
 */
public class PNode {
    public int data;
    public PNode prev;
    public PNode next;
    public PNode(int data,PNode prev,PNode next) {
        this.data=data;
        this.prev=prev;
        this.next=next;
    }
}
