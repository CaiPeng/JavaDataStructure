package binarysearchtree;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    /**
     * 查询元素
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(TreeNode node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else /*if (e.compareTo(node.e) > 0)*/ {
            return contains(node.right, e);
        }
    }

    /**
     * 删除最大值
     */
    public E max() {
        if (size == 0) {
            throw new IllegalArgumentException("BSTree is empty");
        }
        return max(root);
    }

    private E max(TreeNode node) {
        if (node.right == null) {
            return node.e;
        }
        return max(node.right);
    }

    public E maxV2() {
        if (size == 0) {
            throw new IllegalArgumentException("BSTree is empty");
        }
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.e;
    }

    /**
     * 删除最小值
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BSTree is empty");
        }
        return minimum(root).e;
    }


    private TreeNode minimum(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public E minmumV2() {
        if (size == 0) {
            throw new IllegalArgumentException("BSTree is empty");
        }
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.e;
    }

    /**
     * 删除最大值
     */
    public E removeMax() {
        E ret = max();
        root = removeMax(root);
        return ret;
    }

    private TreeNode removeMax(TreeNode node) {
        if (node.right == null) {
            TreeNode leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        return removeMax(node.right);
    }

    /**
     * 删除最小值
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        return removeMin(node.left);
    }

    /**
     * 删除指定元素
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除以node 为根的二分搜索树中值为e的节点，递归
     * 返回删除节点后新的二分搜索树的根
     */
    private TreeNode remove(TreeNode node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { // e == node.e

            //待删除节点左子树为空的情况
            if (node.left == null) {
                TreeNode rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空的情况
            if (node.right == null) {
                TreeNode leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //待删除节点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用该节点替代 删除节点的位置
            TreeNode successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right =null;
            return successor;
        }
    }

    /**
     * 前序遍历 先访问节点 后访问左右子树
     */
    public void preOrder() {
        preOrder(root);
    }

    //前序遍历 以Node 为根节点 先访问节点 后访问左右子树
    private void preOrder(TreeNode node) {
        if (node == null) { //递归终止条件
            return;
        }
        System.out.println(node.e);  //访问节点
        preOrder(node.left);//左子树
        preOrder(node.right);//右子树
    }

    /**
     * 非递归写法  借助栈（后进先出）的概念
     * <p>
     * NONE RECURSION
     */
    public void preOrderV2() {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);//根节点压栈
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop(); //出栈
            System.out.println(cur.e);  //访问节点
            if (cur.right != null) {
                stack.push(cur.right); //右子树压栈
            }
            if (cur.left != null) {
                stack.push(cur.left);//左子树压栈
            }
        }
    }

    /**
     * 中序遍历 先访问节点的左子树，再访问节点的右子树,再访问节点，
     * <p>
     * 调用排序的位置
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (node == null) { //递归终止条件
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);  //访问节点
        inOrder(node.right);
    }

    /**
     * 后序遍历 先访问节点的右子树，再访问节点，在访问节点的左子树
     * <p>
     * 调用排序的位置
     * <p>
     * 应用场景：内存释放
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);  //访问节点
    }

    /**
     * 层序遍历 借助队列
     * <p>
     * 算法设计 最短路径
     */
    public void levelOrder() {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode cur = nodeQueue.remove();
            System.out.println(cur.e);  //访问节点
            if (cur.left != null) {
                nodeQueue.add(cur.left);
            }
            if (cur.right != null) {
                nodeQueue.add(cur.right);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        generateBSTreeString(root, 0, builder);
        return builder.toString();
    }

    //生成以Node为根节点，深度为depth的描述的二叉树的字符串 前序遍历
    private void generateBSTreeString(TreeNode node, int depth, StringBuilder builder) {
        if (node == null) {
            builder.append(generateDepthString(depth) + "NULL\n");
            return;
        }
        builder.append(generateDepthString(depth) + node.e + "\n");
        generateBSTreeString(node.left, depth + 1, builder);
        generateBSTreeString(node.right, depth + 1, builder);
    }

    //深度为depth的描述
    private String generateDepthString(int depth) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            builder.append("--");
        }
        return builder.toString();
    }


}
