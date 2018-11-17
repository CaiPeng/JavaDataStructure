package set;

/**
 * 承载元素的容器，每个元素只能存在一次，去除重复元素
 * <p>
 * 应用：客户统计 文本词汇量统计
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}

