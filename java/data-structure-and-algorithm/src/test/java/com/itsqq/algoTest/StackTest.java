package com.itsqq.algoTest;

import com.itsqq.stack.ArrayStack;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StackTest {

    @Test
    public void test(){
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("a");
        arrayStack.push("b");
        arrayStack.push("c");
        arrayStack.printfArrayStack();
        arrayStack.push("d");
        arrayStack.push("e");
        arrayStack.printfArrayStack();
    }
}
