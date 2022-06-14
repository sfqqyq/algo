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
        if(dataNode==null){
            dataArr[index] = data;
        }else {
            // 往后选址，直到选中一个为空的地址
            int i=index+1;
            while ((i)%dataArr.length!=index){
                if( dataArr[(i)%dataArr.length]==null && !"delete".equals(dataArr[(i)%dataArr.length])){
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

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.add("一");
        hashTable.add("😄");
        hashTable.add("三");
        hashTable.add("四");
        hashTable.add("你好");
        hashTable.add("我是谁？1");
        hashTable.add("我是谁？2");
        hashTable.add("我是谁？3");
        hashTable.add("我是谁？4");
        hashTable.add("我是谁？5");
        hashTable.add("我是谁？6");
        hashTable.add("我是谁？7");
        hashTable.add("我是谁？8");
        hashTable.add("我是谁？9");
        System.out.println(hashTable.dataArr);
    }


}
