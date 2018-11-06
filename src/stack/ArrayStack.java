package stack;

import array.DynamicArray;
import stack.impl.Stack;

public class ArrayStack<E> implements Stack<E> {

    private DynamicArray<E> eDynamicArray;

    public ArrayStack(int capacity) {
        this.eDynamicArray = new DynamicArray<>(capacity);
    }


    public ArrayStack() {
        this.eDynamicArray = new DynamicArray<>();
    }

    public int getCapacity() {
        return eDynamicArray.getCapacity();
    }

    @Override
    public void push(E e) {
        eDynamicArray.addLast(e);
    }


    @Override
    public E pop() {
        return eDynamicArray.removeLast();
    }

    /**
     * 查看栈顶元素
     */
    @Override
    public E peek() {
        return eDynamicArray.getLast();
    }

    @Override
    public int getSize() {
        return eDynamicArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return eDynamicArray.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Stack:Size = %d , capacity = %d \n", getSize(), getCapacity()));
        builder.append("[");
        for (int i = 0; i < eDynamicArray.getSize(); i++) {
            builder.append(eDynamicArray.get(i));
            if (i != eDynamicArray.getSize() - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
