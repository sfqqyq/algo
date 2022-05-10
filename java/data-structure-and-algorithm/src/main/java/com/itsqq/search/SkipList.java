package com.itsqq.search;

/**
 * @desc 跳表的实现
 * @author sfqqyq
 * @date 2022-05-09 15:37:23
 */
public class SkipList {

    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;

    private int levelCount=1;

    private Node head=new Node(); // 带头链表

    /**
     * @desc 查找节点数据
     * @param value 数据
     * @return 返回节点数据
     */
    public Node find(int value){

        Node p =head;
        for (int i = levelCount-1; i >=0 ; i--) {
            // forwards 也就是索引层，存储每一层的索引
            // 查找最下面一层大于或等于value值的节点
            while (p.forwards[i]!=null&&p.forwards[i].data<value){
                p=p.forwards[i];
            }
        }

        // 判断最后查找的节点的值是不是等于给定的值，如果等于这个值，则返回
        if(p.forwards[0]!=null&&p.forwards[0].data==value){
            return p.forwards[0];
        }
        return null;
    }

    public void del(int value){

       // TODO 需要找到哪些节点受到删除节点的影响
        Node p=head;
        Node[] update=new Node[levelCount];
        for (int i = levelCount-1; i >=0 ; i--) {
            while ( p.forwards[i] != null && p.forwards[i].data < value){
                p=p.forwards[i];
            }
            update[i]=p;
        }

        if(p.forwards[0]!=null&&p.forwards[0].data==value){
            // i是层数
            for (int i = levelCount-1; i >=0 ; i--) {
                if(update[i].forwards[i]!=null&&update[i].forwards[i].data==value){
                    update[i].forwards[i]=update[i].forwards[i].forwards[i];
                }
            }
        }

        while (levelCount>1&&head.forwards[levelCount]==null){
            levelCount--;
        }

    }

    /**
     * @desc 新增数据
     * @param value 值
     */
    public void add(int value){
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;

        // 初始化需要更新的节点，从头元素开始
        Node[] update=new Node[level];
        for (int i = 0; i < level; i++) {
            update[i]=head;
        }

        // 一层一层的遍历数据，从最上面开始统计，找出需要更新指针的节点
        Node p=head;
        for (int i = level-1; i >= 0; i--) {
            // while 主要是用来查找最后比value小的节点
            while (p.forwards[i]!=null&&p.forwards[i].data<value){
                p=p.forwards[i];
            }
            update[i]=p;
        }

        // 将需要更新的节点的后续节点让新节点去指向也就是 newNode.forward[i]=update[i].forward[i],I是层数
        for (int i = 0; i < level; i++) {
            newNode.forwards[i]=update[i].forwards[i];
            // 按要更新的节点指向新节点
            update[i].forwards[i]=newNode;
        }

        // 查看是否需要更新层级
        if (levelCount<level)levelCount=level;

    }

    private int randomLevel() {
        int level = 1;
        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL)
            level += 1;
        return level;
    }

    /**
     * @desc 打印全部数据
     */
    public void printAll(){
        Node p=head;
        while (p.forwards[0]!=null){
            System.out.println(p.forwards[0]+" ");
            p=p.forwards[0];
        }
        System.out.println();

    }

    static class Node{
        private int data =-1;
        // 每一层都是一个链表，定义最大层级数
        private Node forwards[] =new Node[MAX_LEVEL];
        private int maxLevel=0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
//        skipList.insert(22);
//        skipList.insert(19);
//        skipList.insert(7);
//        skipList.insert(3);
//        skipList.insert(37);
//        skipList.insert(11);
        skipList.add(22);
        skipList.add(19);
        skipList.add(7);
        skipList.add(3);
        skipList.add(37);
        skipList.add(11);
        skipList.printAll();
        System.out.println();
        Node node = skipList.find(11);
        System.out.println(node);
        System.out.println();
        skipList.del(11);
        skipList.del(37);
        skipList.printAll();
    }

}
