package set;

import binarysearchtree.BSTree;

public class BSTreeSet<E extends Comparable<E>> implements Set<E> {

    private BSTree<E> bst;

    public BSTreeSet() {
        bst = new BSTree<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
