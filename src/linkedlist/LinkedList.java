package linkedlist;


/**
 * 不需要处理固定容量
 * 丧失了随机访问的能力
 * 数组底层开辟的内存是连续的O（1）
 * 链表底层每个元素内存是不连续的，必须通过节点
 * <p>
 * 数组：
 * 最好用于索引有语意的情况
 * 最大优点：支持快速查询
 * <p>
 * 链表：
 * 不适合索引有语意的情况
 * 最大优点：动态
 *
 *
 */
public class LinkedList<E> {

    /**
     * 链表节点 实体类
     */
    private class Node {

        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    //    private Node head;
    private int size;

    public LinkedList() {
//        head =null;
        dummyHead = new Node(null, null);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 链表插入元素: 待添加节点的元素的前一个元素
     * <p>
     * 1。头节点 没有前一个节点，
     * <p>
     * 2。插入顺序很重要
     * <p>
     * 3。虚拟头节点 dummyHead
     * <p>
     * O(n/2)
     */
    public void add(int index, E e) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("Index Illegal");
        }
//        if (index == 0) {
//            addFirst(e);
//        } else {
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
//        }
    }

    /**
     * 链表头添加元素
     * <p>
     * O(1)
     */
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//        head = new Node(e, head);
//        size++;

        add(0, e);
    }

    /**
     * 链表尾部添加元素
     * <p>
     * O(n)
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * Remove
     * <p>
     * O(n/2)
     */
    private E remove(int index) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("Index Illegal");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    /**
     * Remove First
     * <p>
     * O(1)
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * Remove Last
     * O(n)
     */
    public E removeLast() {
        return remove(size);
    }

    /**
     * 获取第Index 个元素
     * <p>
     * O(n)
     */
    public E get(int index) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("Index Illegal");
        }

        Node cur = dummyHead.next; //第Index 个元素
        for (int i = 0; i < index; i++)
            cur = cur.next;

        return cur.e;
    }

    /**
     * Get First
     * <p>
     * O(1)
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * Get Last
     * <p>
     * O(n)
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * Update Linked Index Value
     * <p>
     * O(n)
     */
    public void set(int index, E e) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("Index Illegal");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    /**
     * Search Value
     * <p>
     * O(n)
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (cur.equals(e))
                return true;
            else
                cur = cur.next;
        }
        return false;
    }

    /**
     * Search Value
     * <p>
     * O(n)
     */
    public boolean containsV2(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.equals(e))
                return true;
            else
                cur = cur.next;
        }
        return false;
    }

    /**
     * O(n)
     */
    private String toStringV2() {
        StringBuilder builder = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            builder.append(cur).append("->");
        return builder.toString();

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            builder.append(cur).append("->");
            cur = cur.next;
        }
        builder.append("NULL");
        return builder.toString();

    }
}
