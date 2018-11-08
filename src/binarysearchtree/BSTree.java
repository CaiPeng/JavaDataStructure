package binarysearchtree;

/**
 * 二分搜索树 （left < root,right > root）
 * <p>
 * 如果相等的话可以定义 left<= root 或者 right>=root
 *
 * @param <E> 泛型必须具有可比较性
 */
public class BSTree<E extends Comparable<E>> {

    private class TreeNode {
        public E e;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;
    private int size;

    public BSTree() {
        this.root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 相等元素，相当于已经存在于二分搜索树中，不包括重复的
     */
    public void add(E e) {
        if (root == null) {
            root = new TreeNode(e);
            size++;
        } else {
            add(root, e);
        }

    }

    //递归算法
    private void add(TreeNode node, E e) {
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new TreeNode(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new TreeNode(e);
            size++;
            return;
        }
        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }

    /**
     * 相等元素，相当于已经存在于二分搜索树中，不包括重复的
     */
    public void addV2(E e) {
        root = addV2(root, e);
    }

    /**
     * 递归
     * 返回插入新节点的二分搜索树的根
     */
    private TreeNode addV2(TreeNode node, E e) {
        if (node == null) {
            size++;
            return new TreeNode(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = addV2(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = addV2(node.right, e);
        }
        return node;
    }

}
