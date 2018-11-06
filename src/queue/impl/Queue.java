package queue.impl;

public interface Queue<E> {
    /**
     * 入列
     */
    void enqueue(E e);

    /**
     * 出列
     */
    E dequeue();

    /**
     * 队首元素
     */
    E getFront();

    int getSize();

    boolean isEmpty();
}
