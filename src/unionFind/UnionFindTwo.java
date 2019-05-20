package unionFind;

/**
 * Quick Union
 */
public class UnionFindTwo implements IUnionFind {

    /**
     * parent[i] 代表第i 个元素指向哪个节点
     */
    private int[] parent;

    public UnionFindTwo(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i; // 初始时候每一个节点指向它自己，相当于每一个节点独立的是一棵树
        }
    }

    /**
     * 查看元素 p 和 元素 q 是否属于一个集合
     * 时间复杂度 O(h),h为树的高度
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }


    /**
     * 合并元素 p 和元素 q 所属的集合
     * 时间复杂度 O(h),h为树的高度
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {  // 如果两个元素根节点ID 相同，说明已经是一棵树
            return;
        }
        parent[pRoot] = qRoot; // 否则直接让pRoot 指向 qRoot,即qRoot是pRoot 的根节点
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找过程，查找元素p对应的集合编号
     * 时间复杂度 O(h),h为树的高度
     *
     * @param p 元素
     * @return p 根节点集合编号
     */
    private int find(int p) {
        if (p < 0 && p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        // 思路 从当前节点不断的去向它的根节点查找，直到 p == parent[p]
        while (p != parent[p]) { //  代表p 不是根节点 就查找
            p = parent[p];
        }
        return p;
    }
}
