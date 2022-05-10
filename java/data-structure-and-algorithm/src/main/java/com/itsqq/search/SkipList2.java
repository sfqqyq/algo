package com.itsqq.search;

/**
 * @desc 跳表的实现
 * @author sfqqyq
 * @date 2022-05-09 15:37:23
 */
public class SkipList2 {

    // 最大层数
    private static final int MAX_LEVEL=16;
    // 有一个头结点
    private Node head=new Node();
    // 当前最大的层
    private int levelCount=1;

    // 查找一个数据节点
    public Node find(int value){

        Node p=head;
        for (int i = levelCount-1; i >=0; i--) {
            while (p.forwards[i]!=null && p.forwards[i].data<value){
                p=p.forwards[i];
            }
        }
        if(p.forwards[0]!=null&&p.forwards[0].data==value){
            return p.forwards[0];
        }
        return null;
    }

    // 删除一个节点，并返回节点信息
    public Node del(int value){

        // TODO 统计需要修改的节点
        Node[] update=new Node[levelCount];
        Node p=head;
        for (int i = levelCount-1; i >=0 ; i--) {
            while (p.forwards[i]!=null&&p.forwards[i].data<value){
                p=p.forwards[i];
            }
            update[i]=p;
        }

        // TODO 将数据删除
        Node result=null;
        if(p.forwards[0]!=null&&p.forwards[0].data==value){ // 查看该数据存不存在
            for (int i = levelCount-1; i>=0 ; i--) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
            result= p.forwards[0];
        }

        // TODO 更新levelCount的大小
        while (levelCount>1&&head.forwards[levelCount]==null){
            levelCount--;
        }

        return result;
    }



    // 添加一个数据
    public void add(int value){
        // 随机一个层级
        int level = randomLevel();
        Node newNode = new Node(value,level);

        // TODO 找到所有需要更新的节点
        Node[] update=new Node[level];
        for (int i = 0; i < level; i++) {
            update[i]=head;
        }
        Node p=head;
        // 按层遍历，找到每一层需要更新的节点
        for (int i = level-1; i >=0 ; i--) {
            while (p.forwards[i]!=null&&p.forwards[i].data<value){
                p=p.forwards[i];
            }
            update[i]=p;
        }

        // TODO 按层将新增的数据插入
        for (int i = 0; i < level; i++) {
            newNode.forwards[i]=update[i].forwards[i];
            update[i].forwards[i]=newNode;
        }
        // 更新最高层
        if(levelCount<level)levelCount=level;
    }

    /**
     * @desc 获取随机数1-MAX_LEVEL之间，也就是随机获取层数
     * @return 返回随机数整数
     */
    private int randomLevel(){
        // 获取1-16之间的随机数
        int level= (int) (Math.random() * MAX_LEVEL);
        return level == 0 ? 1 : Math.min(level, MAX_LEVEL);
    }

    // 打印所有的节点
    public void printAll(){
        Node p=head;
        while (p.forwards[0]!=null){
            System.out.println(p.forwards[0]);
            p=p.forwards[0];
        }
    }

    static class Node{
        // 存储结点数据
        private int data;
        // 存储结点指向下一列的节点数组
        private Node[] forwards=new Node[MAX_LEVEL];
        // 当前节点有多大的层级，这个层级是随机获取
        private int maxLevel=0;

        public Node() {}
        public Node(int data, int maxLevel) {
            this.data = data;
            this.maxLevel = maxLevel;
        }

        @Override
        public String toString() {
            return "{ data: " + data + "; levels: " + maxLevel + " }";
        }

    }


    public static void main(String[] args) {
        SkipList2 skipList = new SkipList2();
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
        SkipList2.Node node = skipList.find(11);
        System.out.println(node);
        System.out.println();
        skipList.del(11);
        skipList.del(37);
        skipList.printAll();
    }




}
