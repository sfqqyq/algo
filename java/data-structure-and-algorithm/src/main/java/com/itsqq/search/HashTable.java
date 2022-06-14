package com.itsqq.search;


import lombok.extern.slf4j.Slf4j;

/**
 * @desc 散列表实现
 *       解决散列冲突方式：开放寻址法，适合小数据量
 *       链表法
 */
@Slf4j
public class HashTable {

    private String[] dataArr=new String[10];

    /**
     * @desc 哈希方法
     * @param data 数据
     * @return 数组下标值
     */
    private int hash(String data){
        int i = data.hashCode();
        i = i<0 ? -i : i;
        return i % dataArr.length;
    }

    /**
     * @desc 添加一个数据至散列表中
     * @param data 数据
     */
    public void add(String data){
        int index = hash(data);
        String dataNode = dataArr[index];
        if(dataNode==null || dataNode.equals(data)){
            dataArr[index] = data;
        }else {
            // 往后选址，直到选中一个为空的地址
            int i=index+1;
            while ((i)%dataArr.length!=index){
                // 该位置是空的，或者值相同
                if( dataArr[(i)%dataArr.length]==null || dataArr[(i)%dataArr.length].equals(data)){
                    dataArr[(i)%dataArr.length] = data;
                    break;
                }
                i++;
            }
            if((i)%dataArr.length==index){
                // TODO 数组扩容
                log.info("插入数据失败，容量已满-->>失败数据：{}",data);
            }
        }
    }

    /**
     * @desc 删除数据(如果有相同数据，只删除第一个)
     * @param data 需要删除的数据
     */
    public void del(String data){

        int index = hash(data);
        if(dataArr[index]==null){
            log.info("该数据无法删除--->>>数据不存在--->>>数据：{}",data);
            return;
        }
        if(dataArr[index].equals(data)){
            dataArr[index]="delete";
            return;
        }

        // TODO 查数据删除标记
        // 往后选址，直到选中一个为空的地址
        int i=index+1;
        while ((i)%dataArr.length!=index){
            // 遍历到空数据，那么就退出，查不到该数据
            if(dataArr[(i)%dataArr.length]==null) {
                log.info("无法删除该数据--->>>数据不存在--->>>数据：{}",data);
                break;
            }
            // 遍历查询到该数据
            if(dataArr[(i)%dataArr.length].equals(data)){
                dataArr[(i)%dataArr.length] = "delete";
                log.info("数据删除成功--->>>数据：{}",data);
                break;
            }
            i++;
        }
        if((i)%dataArr.length==index){
            log.info("无法删除该数据--->>>数据不存在--->>>数据：{}",data);
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.add("一");
        hashTable.add("😄");
        hashTable.add("你好");
        hashTable.add("我是谁？1");
        hashTable.add("我是谁？2");
        hashTable.add("我是谁？1");
        System.out.println(hashTable.dataArr);
        hashTable.del("你好");
        System.out.println(hashTable.dataArr);
        hashTable.add("你好");
        System.out.println(hashTable.dataArr);
    }


}
