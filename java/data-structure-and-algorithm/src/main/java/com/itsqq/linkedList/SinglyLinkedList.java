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
        if(p==null || this.node==null) return;

        Node n=this.node;
        // 查询上一个节点
        while (n!=null && n.next != p){
            n=n.next;
        }
        // 如果没有匹配到
        if(n==null)return;
        n.next=n.next.next;
    }
    // 删除指点数据节点
    public void deleteByValue(int value){
        if(this.node==null)return;
        Node n=this.node;
        // 查找上一个节点
        while (n.next!=null && n.next.data!=value){
            n=n.next;
        }
        if(n.next==null)return;
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


    // 判断是不是回文
    public boolean palindrome(){
        if(this.node == null)return false;

        System.out.println("开始寻找中间节点---利用快慢指针");
        Node slowN=this.node;
        Node fastN=this.node;
        if(slowN.next==null){
            System.out.println("只有一个元素");
            return true;
        }
        // 快指针单数节点，最后一个fastN.next==null,双数节点fastN.next.next==null
        while (fastN.next!=null && fastN.next.next!=null){
            slowN=slowN.next;
            fastN=fastN.next.next;
        }
        //打印中间节点的数据
        System.out.println("中间节点："+slowN.data);

        Node leftLink=this.node; // 左边的链表
        Node rightLink= inverseLinkList(slowN.next); // 右边的链表

        // 遍历
        while (leftLink!=null&&rightLink!=null){
            if(leftLink.data != rightLink.data){
                return false;
            }
            leftLink=leftLink.next;
            rightLink=rightLink.next;
        }
        return true;
    }

    //带结点的链表翻转（不带头结点）
    public Node inverseLinkList(Node H){
        if(H==null || H.next==null){
            return H;
        }
        Node p=H;
        Node newH=null;
        while (p!=null){
            Node tmpN=p.next;// 存储p后面的节点
            p.next=newH; // p节点指向前一个空间
            newH=p; // 新链表的头移动到p,扩长一步链表
            p=tmpN;//p指向原始链表p的下一个空间
        }
        return newH;
    }


    // 测试回文
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList(10);
        list.insertTail(11);
        list.insertTail(11);
        list.insertTail(10);
//        list.insertTail(11);
        list.printAll();
        boolean b = list.palindrome();
        System.out.println("是否是回文："+b);
    }

    // 测试增删查
    public static void main1(String[] args) {
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
        // 删除最后一个元素
        list.deleteByNode(list.findByValue(13));
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