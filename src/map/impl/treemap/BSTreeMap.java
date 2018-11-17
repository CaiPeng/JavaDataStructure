package map.impl.treemap;

import map.Map;

public class BSTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class TreeNode {
        public K k;
        public V v;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(K k, V v) {
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;
    private int size;

    public BSTreeMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(K k, V v) {
        root = add(root, k, v);
    }

    private TreeNode add(TreeNode node, K k, V v) {
        if (node == null) {
            size++;
            return new TreeNode(k, v);
        }
        if (k.compareTo(node.k) < 0)
            node.left = add(node.left, k, v);
        else if (k.compareTo(node.k) > 0)
            node.right = add(node.right, k, v);
        else // key.compareTo(node.key) == 0
            node.v = v;

        return node;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private TreeNode getNode(TreeNode node, K key) {
        if (node == null)
            return null;
        if (key.equals(node.k))
            return node;
        else if (key.compareTo(node.k) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    @Override
    public V remove(K k) {
        TreeNode node = getNode(root, k);
        if (node != null) {
            root = remove(root, k);
            return node.v;
        }
        return null;
    }

    private TreeNode remove(TreeNode node, K k) {
        if (node == null)
            return null;
        if (k.compareTo(node.k) < 0) {
            node.left = remove(node.left, k);
            return node;
        } else if (k.compareTo(node.k) > 0) {
            node.right = remove(node.right, k);
            return node;
        } else {   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if (node.left == null) {
                TreeNode rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.right == null) {
                TreeNode leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            TreeNode successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private TreeNode minimum(TreeNode node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    @Override
    public boolean contains(K k) {
        return getNode(root, k) != null;
    }

    @Override
    public V get(K k) {
        return getNode(root, k) == null ? null : getNode(root, k).v;
    }

    @Override
    public void set(K k, V v) {
        TreeNode node = getNode(root, k);
        if (node == null)
            throw new IllegalArgumentException(k + " doesn't exist!");

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

