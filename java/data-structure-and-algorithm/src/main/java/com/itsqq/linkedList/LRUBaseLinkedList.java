package com.itsqq.linkedList;


/**
 * @author sfqqyq
 * @date 2022年03月16日 3:55 下午
 * @desc 基于单链表的LRU缓存算法实现
 */
public class LRUBaseLinkedList<T> {

    private SNode<T> head;
    private final static int DEFAULT_CAPACITY=5;// 容量
    public LRUBaseLinkedList(){ }
    public LRUBaseLinkedList(T data){
        this.head=new SNode<>(data,null);
    }

    // 查询该元素是不是在链表中
    private SNode<T> findNode(T data){
        if (head==null)return null;

        SNode<T> sNode=this.head;
        while (sNode.next!=null){
            if(data.equals(sNode.data)){
                return sNode;
            }
            sNode=sNode.next;
        }
        if(data.equals(sNode.data)){
            return sNode;
        }
        return null;
    }

    // 添加一个数据
    private void addData(T data){
        SNode<T> sNode = findNode(data);
        if(sNode!=null){ // 原来就有这个数据
            // TODO 删除原来的数据，将该数据插入到链表头部
            deleteNodeByNode(sNode);
            head=new SNode<>(data,head);
        }else {  // 原来没有这个数据
            // TODO 如果链表满了，删除尾结点，将数据存放在头部
            // TODO 如果链表没满，直接将元素放在头部
            if(getLength()>=DEFAULT_CAPACITY){// 满了
                deleteLastNode();
                head=new SNode<>(data,head);
            }else {//没满
                head=new SNode<>(data,head);
            }
        }
    }

    // 按照结点删除数据
    private boolean deleteNodeByNode(SNode<T> node) {
        if(head==null)return true;
        SNode<T> sNode=this.head;
        if(sNode==node){
            this.head=this.head.next;
            return true;
        }
        while (sNode.next !=null && sNode.next!=node){
            sNode=sNode.next;
        }
        if(sNode.next==null){// 没有查到该结点
            return true;
        }
        sNode.next=sNode.next.next;
        return true;
    }

    // 删除尾结点
    public boolean deleteLastNode(){
        if(head==null)return true;

        SNode<T> sNode=this.head;
        SNode<T> tmpN = null; // 存sNode上一个元素
        while (sNode.next!=null){
            tmpN=sNode;
            sNode=sNode.next;
        }
        if(tmpN !=null){
            tmpN.next=sNode.next;
        }else {
            this.head=null;
        }
        return true;
    }

    // 打印所有的数据
    public void printAll(){
        if(this.head==null)return;
        SNode<T> sNode=this.head;
        while (sNode.next!=null){
            System.out.print(sNode.data+",");
            sNode=sNode.next;
        }
        System.out.print(sNode.data);
    }
    // 获取链表中元素个数
    public int getLength(){
        if(head==null)return 0;
        SNode<T> tmpSN=this.head;
        int sum=1;
        while (tmpSN.next!=null){
            sum++;
            tmpSN=tmpSN.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        LRUBaseLinkedList<Integer> list = new LRUBaseLinkedList<>();
        // 测试新增功能
//        list.addData(10);
//        list.addData(11);
//        list.addData(12);
//        list.addData(13);
//        list.addData(14);
//        list.addData(15);
//        list.printAll();
        // 测试缓存功能
        list.addData(10);
        list.addData(11);
        list.addData(12);
        list.addData(13);
        list.addData(14);
        list.addData(12);
        list.addData(10);
        list.printAll();
    }

}

class SNode<T>{
    public T data;
    public SNode<T> next;
    public SNode(T data,SNode<T> next){
        this.data=data;
        this.next=next;
    }
}
