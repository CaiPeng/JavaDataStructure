package map.impl.linkedmap;

import map.Map;


/**
 * @param <K> key不能重复
 * @param <V> value 覆盖
 */
public class LinkedMap<K, V> implements Map<K, V> {

    private class Node {
        public K k;
        public V v;
        public Node next;

        public Node(K k, V v, Node next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public Node(K k) {
            this(k, null, null);
        }

        public Node(K k, V v) {
            this(k, v, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "k=" + k +
                    ", v=" + v +
                    '}';
        }
    }

    private Node dummyHead;

    private int size;

    public LinkedMap() {
        dummyHead = new Node();
        size = 0;
    }

    private Node getNode(K k) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.k.equals(k)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }


    @Override
    public void add(K k, V v) {
        Node node = getNode(k);
        if (node == null) {
            dummyHead.next = new Node(k, v, dummyHead.next);
            size++;
        } else {
            node.v = v; //key重复，更新Value
        }
    }

    @Override
    public V remove(K k) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.k.equals(k)) {
                break;
            }
            pre = pre.next;
        }
        if (pre.next != null) {
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.v;
        }
        return null;
    }

    @Override
    public boolean contains(K k) {
        return get(k) == null;
    }

    @Override
    public V get(K k) {
        return getNode(k) == null ? null : getNode(k).v;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k);
        if (node == null) {
            throw new IllegalArgumentException("Key does not exit");
        }
        node.v = v;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


}
