package unionFind;

/**
 * Quick Find
 * <p>
 * unionElements() --> O(N) 数量较大时候 性能较差
 * isConnected() --> O(1)
 */
public class UnionFindOne implements IUnionFind {

    /**
     * 存放每一个数据所对应的所属的集合的编号
     */
    private int[] id;

    public UnionFindOne(int size) {
        this.id = new int[size];
        for (int i = 0; i < id.length; i++) { // 每一个元素对应的集合编号都不一样 0 --> 0
            id[i] = i; // 每一个元素所属不同的集合，没有任何元素是相连的
        }
    }

    /**
     * 查询元素p 对应的集合编号
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素 p 和 元素 去所属于的集合
     *
     * @param p element p
     * @param q element q
     *          <p>
     *          复杂度O（n）
     */
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) { // 已经是相连的 直接return
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) { // 更改ID
                id[i] = qId;
            }
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查找元素p 所对应的集合编号
     *
     * @param p 元素
     * @return 集合编号
     * <p>
     * 复杂度 O（1）
     */
    private int find(int p) {
        if (p < 0 && p >= id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }
}
