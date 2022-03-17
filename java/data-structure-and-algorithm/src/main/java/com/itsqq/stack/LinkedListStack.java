package com.itsqq.stack;

/**
 * @author sfqqyq
 * @date 2022年03月17日 1:32 下午
 * @desc 基于链表实现栈（链式栈）
 */
public class LinkedListStack<T> {

    private Node<T> items;

    // 初始化
    public LinkedListStack() {}
    public LinkedListStack(T item) {
        this.items=new Node<>(item,null);
    }
    // 入栈操作
    public boolean push(T item) {
        // 将节点放在链尾
//        if(this.items==null){
//            this.items=new Node<>(item,null);
//            return true;
//        }
//        Node<T> tmpN=this.items;
//        while (tmpN.next!=null){
//            tmpN=tmpN.next;
//        }
//        tmpN.next=new Node<>(item,null);

        // 将结点放在链头
        Node<T> node=new Node<>(item,null);
        node.next=this.items;
        this.items=node;
        return true;
    }
    // 出栈操作
    public T pop() {

        // 出链尾的结点
//        if(items==null)return null;
//        // 只有一个元素
//        if(items.next==null){
//            T data=items.data;
//            items=null;
//            return data;
//        }
//        Node<T> tmpN=this.items;
//        Node<T> node=tmpN;
//        while (tmpN.next!=null){
//            node=tmpN;
//            tmpN=tmpN.next;
//        }
//        T data = tmpN.data;
//        node.next=null;
        if(this.items==null) return null;

        // 出链头的数据
        T data=this.items.data;
        this.items=this.items.next;

        return data;
    }
    // 获取栈元素
    public int getSize(){
        Node<T> tmpN=this.items;
        int sum=0;
        while (tmpN!=null){
            sum++;
            tmpN=tmpN.next;
        }
        return sum;
    }
    // 打印所有的元素
    public void printAll(){
        Node<T> tmpN=this.items;
        while (tmpN!=null){
            System.out.print(tmpN.data+",");
            tmpN=tmpN.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.printAll();
        System.out.println("POP:"+stack.pop());
        stack.printAll();
        stack.pop();
        stack.pop();
        stack.printAll();
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