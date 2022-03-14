package com.itsqq.linkedList;

/**
 * @author sfqqyq
 * @date 2022年03月12日 9:37 上午
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 */
public class SinglyLinkedList {
    private Node node;
    public SinglyLinkedList(){
    }
    public SinglyLinkedList(int data){
        this.node=new Node(data,null);
    }
    // 通过值查询节点
    public Node findByValue(int val){
        Node n=this.node;
        while (n!=null && n.data!=val){
            n=n.next;
        }
        return n;
    }
    // 通过索引查找节点值
    public Node findByIndex(int index){
        checkIndex(index);
        Node n=this.node;
        for (int i = 0; i < index; i++) {
            n=n.next;
        }
        return n;
    }
    // 获取链表长度
    public int getSize(){
        if(this.node==null){
            return 0;
        }
        int size=1;
        Node n=this.node;
        while (n.next!=null){
            n=n.next;
            size++;
        }
        return size;
    }
    // 在链表头部插入数据
    public void insertToHead(int value){
        insertToHead(new Node(value,null));
    }
    // 在链表头部插入一个节点
    public void insertToHead(Node newNode) {
        if(this.node == null){
            this.node = newNode;
            return;
        }
        newNode.next= this.node;
        this.node=newNode;
    }
    // 在链表尾部插入节点
    public void insertTail(int value){
        if(this.node == null){
            this.node = new Node(value,null);
            return;
        }
        Node n=this.node;
        while (n.next!=null){
            n=n.next;
        }
        n.next=new Node(value,null);
    }
    // 在p节点之后插入值为value的节点
    public void insertAfter(Node p,int value){
        if(p==null)return;
        insertAfter(p,new Node(value,null));
    }
    // 在节点p后加一个新节点
    public void insertAfter(Node p, Node newNode) {
        if(p==null)return;
        newNode.next=p.next;
        p.next=newNode;
    }
    // 在p节点之前插入值为value的节点
    public void insertBefore(Node p,int value){
        insertBefore(p,new Node(value,null));
    }
    // 在节点之前插入节点
    public void insertBefore(Node p,Node newNode){
        if(p==null)return;
        Node n=this.node;
        // p是第一个节点
        if(n==p){
            insertToHead(newNode);
            return;
        }
        // 查到p节点前一个节点
        while (n.next==p){
            n=n.next;
        }
        // 查询上一个节点
        n.next=newNode;
        newNode.next=p;
    }
    // 删除指定节点
    public void deleteByNode(Node p){
        Node n=this.node;
        // 查询上一个节点
        while (n.next!=p){
            n=n.next;
        }
        n.next=n.next.next;
    }
    // 删除指点数据节点
    public void deleteByValue(int value){
        Node n=this.node;
        while (n.next.data!=value){
            n=n.next;
        }
        n.next=n.next.next;
    }
    // 打印节点数据
    public void printAll(){
        checkNodeIsEmpty();

        Node n=this.node;
        while (n.next !=null){
            System.out.print(n.data+",");
            n=n.next;
        }
        System.out.println(n.data);

    }
    // 检查索引是否合法
    private void checkIndex(int index){
        if(index <0 || index>=getSize()){
            throw new IllegalArgumentException("索引越界。。。");
        }
    }
    // 检查索引是否合法
    private void checkNodeIsEmpty(){
        if(this.node == null){
            throw new IllegalArgumentException("链表为空。。。");
        }
    }

    public static void main(String[] args) {
        // 初始化数据
        SinglyLinkedList list = new SinglyLinkedList(10);
        list.insertTail(11);
        list.insertTail(12);
        list.insertTail(13);
        list.printAll();
        // 1、删除12这个元素
        list.deleteByValue(12);
        list.printAll();
        // 2、按照索引查询节点
        Node node = list.findByIndex(1);
        System.out.println(node.data);
        // 在头部插入节点
        list.insertToHead(9);
        list.printAll();
    }

}

class Node{
    public int data;
    public Node next;
    public Node(int data,Node next) {
        this.data=data;
        this.next=next;
    }
}