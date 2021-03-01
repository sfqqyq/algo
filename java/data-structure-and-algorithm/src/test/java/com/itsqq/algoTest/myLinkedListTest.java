package com.itsqq.algoTest;

import com.itsqq.util.MyLinkedList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class myLinkedListTest {
    @Test
    public void test1(){
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("123");
        myLinkedList.add("321");
        myLinkedList.add("hjuih");
        System.out.println(myLinkedList);

        String s = myLinkedList.get(1);
        System.out.println(s);
    }

}
