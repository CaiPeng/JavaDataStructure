package array;

public class Array<E> {

    private E[] data;
    private int size;

    /**
     * @param capacity 传数组的容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
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
     * @param e 向所有元素后添加一个新元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * @param e 向所有元素第一个添加一个新元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 指定位置添加元素
     *
     * @param index 指定位置
     * @param e     元素
     */
    public void add(int index, E e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add Failed");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed");
        }
        //每一个元素向后一个位置
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
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

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size);
    }

    /**
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

        if (size == data.length / 2) {
            
        }
        return ret;
    }

    /**
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

    /**
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
     * @return 赵大的索引
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
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
