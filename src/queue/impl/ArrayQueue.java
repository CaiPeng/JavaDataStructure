package queue.impl;

import array.DynamicArray;

public class ArrayQueue<E> implements Queue<E> {

    private DynamicArray<E> eDynamicArray;

    public ArrayQueue(int capacity) {
        this.eDynamicArray = new DynamicArray<>(capacity);
    }

    public ArrayQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        eDynamicArray.addLast(e);
    }

    @Override
    public E dequeue() {
        return eDynamicArray.removeFirst();
    }

    @Override
    public E getFront() {
        return eDynamicArray.getFirst();
    }

    @Override
    public int getSize() {
        return eDynamicArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return eDynamicArray.isEmpty();
    }

    public int getCapacity() {
        return eDynamicArray.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue:Size = %d , capacity = %d \n", getSize(), getCapacity()));
        builder.append("front [");
        for (int i = 0; i < eDynamicArray.getSize(); i++) {
            builder.append(eDynamicArray.get(i));
            if (i != eDynamicArray.getSize() - 1) {
                builder.append(", ");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }
}
