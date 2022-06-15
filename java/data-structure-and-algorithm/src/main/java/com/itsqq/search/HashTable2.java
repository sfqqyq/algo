package com.itsqq.search;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @desc 散列表实现
 *       链表法：适合大数据量
 */
@Slf4j
public class HashTable2 {

    private Node[] nodes=new Node[10];

    /**
     * @desc 哈希方法
     * @param key 键值
     * @return 数组下标值
     */
    private int hash(String key){
        return Math.abs(key.hashCode()) % nodes.length;
    }

    /**
     * @desc 添加一个数据至散列表中
     * @param data 数据
     */
    public void add(String key,String data){
        // 计算hash值
        int index = hash(key);
        if(nodes[index]==null){
            Node node = new Node(key,data, null);
            nodes[index]=node;
        }else {
            Node tmpNode= nodes[index];
            while (tmpNode.next!=null){
                if(tmpNode.key.equals(key)){
                    tmpNode.data=data;
                    break;
                }
                tmpNode=tmpNode.next;
            }
            if(tmpNode.next==null){
                tmpNode.next=new Node(key,data, null);
            }

        }
    }

    /**
     * @desc 查找元素
     * @param key 键值
     * @return 返回节点数据
     */
    public String find(String key){
        int index = hash(key);
        Node tmpNode = nodes[index];
        while (tmpNode!=null){
            if(tmpNode.key.equals(key)){
                return tmpNode.data;
            }
            tmpNode=tmpNode.next;
        }
        return null;
    }


    /**
     * @desc 删除数据(如果有相同数据，只删除第一个)
     * @param key 需要删除的数据
     */
    public boolean del(String key){
        int index = hash(key);
        Node tmpNode = nodes[index];
        if(tmpNode==null) return false;
        if(tmpNode.key.equals(key)){
            // 删除头结点
            if(nodes.length==1) nodes[0]=null;
            if(nodes.length>=2) nodes[0]=nodes[1];
        }
        while (tmpNode.next!=null){
            if(tmpNode.next.key.equals(key)){
                // 删除中间节点
                tmpNode.next=tmpNode.next.next;
                return true;
            }
            tmpNode=tmpNode.next;
        }
        return false;

    }

    public static void main(String[] args) {
        HashTable2 hashTable = new HashTable2();
        for (int i = 0; i < 20; i++) {
            hashTable.add("1"+i,"1"+i);
        }
        System.out.println(hashTable);
        String s = hashTable.find("114");
        System.out.println(s);
        boolean del = hashTable.del("114");
        System.out.println(hashTable);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Node{
        String key;
        String data;
        Node next;
    }


}
