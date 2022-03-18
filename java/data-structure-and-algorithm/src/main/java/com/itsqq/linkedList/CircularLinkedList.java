package com.itsqq.linkedList;

/**
 * @author sfqqyq
 * @date 2022年03月16日 1:52 下午
 * @desc 循环链表
 */
public class CircularLinkedList {

    private Node head;
    public CircularLinkedList(){}
    public CircularLinkedList(int val){
        this.head=new Node(val,null);
        this.head.next=this.head;
    }

    public boolean add(int val){
        if(head==null){
            this.head=new Node(val,null);
            this.head.next=this.head;
            return true;
        }

        Node tmpN=head;
        while (tmpN.next!=head){
            tmpN=tmpN.next;
        }
        tmpN.next=new Node(val,head);
        return true;
    }
    public boolean delete(int val){
        if(head==null)return false;
        Node tmpN=head;
        // 删除头
        if(head.data==val){
            if(tmpN.next==head){// 如果只有一个元素
                head=null;
                return true;
            }
            while (tmpN.next!=head){
                tmpN=tmpN.next;
            }
            tmpN.next=tmpN.next.next;
            head=head.next;
            return true;
        }
        while (tmpN.next!=head){
            if(tmpN.next.data==val){
                tmpN.next=tmpN.next.next;
                return true;
            }
            tmpN=tmpN.next;
        }
        return false;
    }
    public Node find(int val){

        Node tmpN=head;
        while (tmpN.next!=head){
            if (tmpN.data==val) {
                return tmpN;
            }
            tmpN=tmpN.next;
        }
        if (tmpN.data==val)return tmpN;

        return null;
    }
    public void printfAll(){
        if(head==null)return;
        Node tmpN=head;
        while (tmpN.next!=head){
            System.out.print(tmpN.data+",");
            tmpN=tmpN.next;
        }
        System.out.println(tmpN.data);
    }

    public static void main(String[] args) {
        CircularLinkedList cLinkedList=new CircularLinkedList();
         // 添加测试
        cLinkedList.add(10);
//        cLinkedList.add(11);
//        cLinkedList.add(12);
        cLinkedList.printfAll();
        // 删除测试
        boolean delete = cLinkedList.delete(10);
        cLinkedList.printfAll();
        System.out.println("删除："+delete);
        // 查找测试
//        Node node = cLinkedList.find(12);
//        System.out.println("查找："+( node==null ? null : node.data));
    }

}

