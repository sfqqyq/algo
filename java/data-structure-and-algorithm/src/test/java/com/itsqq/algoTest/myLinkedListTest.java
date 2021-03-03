package com.itsqq.algoTest;

import com.itsqq.list.MyLinkedList;
import com.itsqq.list.MyList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

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

    @Test
    public void test2(){
        MyList<String> myList = new MyList<>();
        myList.add("123");
        myList.add("234");
        myList.add("345");
        myList.printfList();
        String s = myList.get(0);
        String s1 = myList.get(1);
        String s2 = myList.get(2);
        System.out.println(s+"-----"+s1+"-----"+s2);


        LinkedList<Object> linkedList = new LinkedList<>();
    }

}
