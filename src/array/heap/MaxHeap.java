package array.heap;

import array.DynamicArray;

/**
 * 二叉堆 是一棵完全二叉树（元素顺序排列成树的形状）
 * 满二叉树（都有子孩子）
 * <p>
 * 堆中的某个节点的值总是不大于其父节点的值
 * <p>
 * 最大堆：根节点 最大值 每个节点大于他的孩子节点
 * <p>
 * 数组存储 二叉堆
 * parent (i)= i/2
 * <p>
 * left child(i) = 2 *i
 * right child(i) = 2 *i +1
 * <p>
 * 数组实现最大堆
 */
public class MaxHeap<E extends Comparable<E>> {

    private DynamicArray<E> data;

    public MaxHeap(int capacity) {
        data = new DynamicArray<>(capacity);
    }

    public MaxHeap() {
        data = new DynamicArray<>();
    }

    public MaxHeap(E[] eArray) {
        data = new DynamicArray<>(eArray);
        heapify();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("Index-0 does not have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回一个完全二叉树表示的数组中 一个索引表示的左孩子节点的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回一个完全二叉树表示的数组中 一个索引表示的右孩子节点的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 堆中添加元素 O(NLogN)
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * @param k 上浮的索引
     */
    private void siftUp(int k) {
        // 比较K 所在的元素和K所在的父亲元素值，如果大于的话 交换
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);  //更新索引
        }
    }

    /**
     * 堆中取出最大的元素
     * <p>
     * 最后一个元素 拿到堆顶
     * 最后一个元素删除
     * 堆变换为最大堆 siftDown(下沉： 选择两个孩子之间最大的元素，如果最大的元素比自身还要大，则替换)
     */
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1); //堆顶 和 最后一个元素交换
        data.removeLast(); //删除最后一个元素
        siftDown(0);
        return ret;
    }

    /**
     * siftDown(下沉： 选择两个孩子之间最大的元素，如果最大的元素比自身还要大，则替换)
     */
    private void siftDown(int k) {
        //左孩子为空
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k); //左孩子索引
            if (j + 1 < data.getSize() //有右孩子
                    && data.get(j + 1).compareTo(data.get(j)) > 0) { //右孩子大于左孩子
                j = rightChild(k);
                //data[j] 是 leftChild 和 rightChild 中的最大值
                if (data.get(k).compareTo(data.get(j)) > 0) { //比较当前值和左右子孩子的最大值
                    break;
                } else {
                    data.swap(k, j); //交换
                    k = j;
                }
            }
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Heap is empty.");
        }
        return data.get(0);
    }

    /**
     * Heapify：将任意数组整理成堆的形状 O(N)
     * <p>
     * 1.看成完全二叉树
     * <p>
     * 2.最后一个非叶子结点 索引
     * 拿到最后一个叶子结点的父亲节点
     * <p>
     * 3.siftDown
     */
    public void heapify() {
        for (int i = parent(data.getSize() - 1); i > 0; i++) {
            siftDown(i);
        }
    }


    /**
     * replace: 取出最大元素(替换新元素) 放入新的元素
     * <p>
     * 先extractMax 再add 两次O(logN)
     * <p>
     * 先将堆顶替换成新的元素以后siftDown 一次O(logN)
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);//堆顶元素替换成e
        siftDown(0);
        return ret;
    }

}
