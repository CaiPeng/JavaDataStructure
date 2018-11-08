package binarysearchtree;

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
