package array;

/**
 * 动态数组
 * <p>
 * 思想： 新建一个新的数组，容量需要进行扩大，
 * 然后让成员变量数组指针指向新建的数组，原来的数组
 * 没有指针指向，会被Java 垃圾回收器回收
 * <p>
 * 时间复杂度分析：
 * 增: O(n)
 * 删: O(n)
 * 改: 已知索引O(1),未知索引：O(n)
 * 查：已知索引O(1),未知索引：O(n)
 * <p>
 * 添加操作： 均摊时间复杂度
 * <p>
 * 复杂度震荡: capacity = n
 * addLast    扩容  之后紧接着 removeLast 两次时间复杂度 O(n)
 * removeLast
 * 原因： removeLast 时resize() 过于着急
 * 解决方案：Lazy  缩容时候 当size == capacity/4 才将capacity减半 空间换时间
 */
public class DynamicArray<E> {

    private E[] data;
    private int size;

    /**
     * @param capacity 传数组的容量
     */
    public DynamicArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public DynamicArray() {
        this(10);
    }

    public DynamicArray(E[] eArray) {
        data = (E[]) new Object[eArray.length];
        for (int i = 0; i < eArray.length; i++) {
            data[i] = eArray[i];
        }
        size = eArray.length;
    }

    /**
     * @return 数组长度
     */
    public int getSize() {
        return size;
    }

    /**
     * @return 当前数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 均摊时间复杂度
     * O(1)
     *
     * @param e 向所有元素后添加一个新元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * @param e 向所有元素第一个添加一个新元素 O(n)
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 指定位置添加元素
     * <p>
     * 时间复杂度，index取值的概率是一样的
     * 每个元素期望是多少，平均时间度O(n/2) ~~ O(n)，
     * 时间复杂度 ：
     * 需要按照最坏的方案计算，
     * 考虑最好的意义不大
     *
     * @param index 指定位置
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        //每一个元素向后一个位置
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 数组扩容 :
     * 思想，数组当前长度或大或小，不理想，最好是倍数
     * <p>
     * ArrayList 扩容是原来Size的1.5倍数
     * <p>
     * 时间复杂度：O(n)
     * <p>
     * 均摊时间复杂度： 假设capacity = 8, 并且每一次添加操作都是用addLast,
     * 9次addLast 操作，触发一次resize,总共进行了17次基本操作，平均每次addLast
     * 就执行2次基本操作（扩容倍数），
     * 假设capacity = n,n+1次addLast,触发resize,总共进行2n+1次基本操作
     * 平均每次addLast就执行2次基本操作（扩容倍数），
     *
     * @param newCapacity 新数组长度
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 删除一个
     *
     * @param e 删除元素
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 时间复杂度：O(n)
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 均摊时间复杂度
     * O(1)
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 时间复杂度：O(n)
     *
     * @param index 删除索引元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove Failed");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 时间复杂度：O(1)： 支持随机索引
     *
     * @param index 索引
     * @param e     索引对应元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set Failed");
        }
        data[index] = e;
    }


    /**
     * @param index 索引
     * @return 索引对应元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get Failed");
        }

        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    /**
     * 时间复杂度：O(n)
     *
     * @return 是否包含
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 时间复杂度：O(n)
     *
     * @return 元素的索引
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 交换
     */
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array:Size = %d , capacity = %d \n", size, data.length));
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
