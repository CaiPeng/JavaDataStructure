package unionFind;

public interface IUnionFind {

    /**
     * 两个元素是否所属同一个集合
     * 是否是可以连接的
     * <p>
     * 参数 传递的是 ID
     */
    boolean isConnected(int p, int q);

    /**
     * 合并
     */
    void unionElements(int p, int q);

    /**
     * @return SIZE
     */
    int getSize();


}
