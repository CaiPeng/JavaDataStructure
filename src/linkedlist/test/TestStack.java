package linkedlist.test;

import stack.impl.Stack;

import java.util.Random;

public class TestStack {

    public double testStack(Stack<Integer> stack, int optionsCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < optionsCount; i++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < optionsCount; i++)
            stack.pop();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;

    }
}
