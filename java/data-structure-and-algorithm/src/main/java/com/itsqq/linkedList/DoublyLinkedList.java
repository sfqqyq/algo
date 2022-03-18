package com.itsqq.linkedList;

/**
 * @author sfqqyq
 * @date 2022年03月16日 2:57 下午
 * @desc 双向链表
 */
public class DoublyLinkedList {
    PNode head;
    public DoublyLinkedList(){
    }
    public DoublyLinkedList(int val){
        this.head=new PNode(val,null,null);
    }

    // 插入数据
    public boolean add(int val){
        if(head==null){
            this.head=new PNode(val,null,null);
            return true;
        }
        PNode tmpPN=head;
        while (tmpPN.next!=null){
            tmpPN=tmpPN.next;
        }
        tmpPN.next=new PNode(val,tmpPN,null);
        return true;
    }
    // 删除数据
    public boolean delete(int val){
        if(head==null)return false;
        PNode tmpPN=head;
        if(tmpPN.data==val){
            // 如果只有一个元素
            if(tmpPN.next!=null){
                tmpPN.next.prev=null;
            }
            head=tmpPN.next;
            return true;
        }
        while (tmpPN.next!=null){
            if(tmpPN.data==val){
                tmpPN.prev.next=tmpPN.next;
                tmpPN.next.prev=tmpPN.prev;
                return true;
            }
            tmpPN=tmpPN.next;
        }
        // 最后一个元素
        if(tmpPN.data==val){
            tmpPN.prev.next=null;
            return true;
        }
        return false;
    }
    // 查询数据
    public PNode find(int val){
        if(head==null)return null;
        PNode tmpPN=head;
        while (tmpPN.next!=null){
            if(tmpPN.data==val){
                return tmpPN;
            }
            tmpPN=tmpPN.next;
        }
        if(tmpPN.data==val){
            return tmpPN;
        }
        return null;
    }
    public void printAll(){
        if(head==null)return;
        PNode tmpPN=head;
        while (tmpPN.next!=null){
            System.out.print(tmpPN.data+",");
            tmpPN=tmpPN.next;
        }
        System.out.println(tmpPN.data);
    }

    public static void main(String[] args) {
        DoublyLinkedList dLinkedList = new DoublyLinkedList();
        // 测试添加元素
        dLinkedList.add(10);
//        dLinkedList.add(11);
//        dLinkedList.add(12);
        dLinkedList.printAll();
        // 测试删除元素
        dLinkedList.delete(10);
        dLinkedList.printAll();
        // 测试查找元素
        PNode pNode = dLinkedList.find(12);
        System.out.println("查找元素："+(pNode==null?null:pNode.data));
    }



}
