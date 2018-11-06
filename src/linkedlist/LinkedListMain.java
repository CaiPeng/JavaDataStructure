package linkedlist;

import linkedlist.test.TestStack;
import stack.ArrayStack;


public class LinkedListMain {

    public static void main(String[] args) {
        TestStack testStack = new TestStack();
        double arrayStackTime = testStack.testStack(new ArrayStack<Integer>(), 100000);
        System.out.println("ArrayStackTime " + arrayStackTime);
        double listStackTime = testStack.testStack(new LinkedListStack<>(), 100000);
        System.out.println("ListStackTime " + listStackTime);
    }
}
