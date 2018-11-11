package array.heap.priorityqueue;

import array.heap.MaxHeap;
import queue.impl.Queue;

/**
 * 优先队列 拿出优先级最高的
 * <p>
 * 底层普通线性结构实现 入队O(1) 出队O（N）
 * <p>
 * 底层顺序线性结构 入队O（n） 出队O（1）
 * <p>
 * 堆 入队O(logN) 出队O（logN）
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
