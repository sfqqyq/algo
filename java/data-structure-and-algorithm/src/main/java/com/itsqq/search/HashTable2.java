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
     * @param data 数据
     * @return 数组下标值
     */
    private int hash(Node data){
        return Math.abs(data.hashCode()) % nodes.length;
    }

    /**
     * @desc 添加一个数据至散列表中
     * @param data 数据
     */
    public void add(String data){
    }

    /**
     * @desc 删除数据(如果有相同数据，只删除第一个)
     * @param data 需要删除的数据
     */
    public void del(String data){
    }

    public static void main(String[] args) {
        System.out.println(Math.abs(22));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Node{
        String data;
        Node node;
    }


}
