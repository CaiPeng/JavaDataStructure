package unionFind;

import java.util.Random;

public class UnionFindMain {

    /**
     * @param unionFind 并查集实现类
     * @param m         执行次数
     * @return 时间
     */
    private static double testUF(IUnionFind unionFind, int m) {
        int size = unionFind.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) { // m次合并
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) { // m次两个元素是否所属同一个集合
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 10000000;
        int m = 10000000;

//        UnionFindOne uf1 = new UnionFindOne(size);
//        System.out.println("UnionFindOne : " + testUF(uf1, m) + " s");
//
//        UnionFindTwo uf2 = new UnionFindTwo(size);
//        System.out.println("UnionFindTwo : " + testUF(uf2, m) + " s");

        UnionFindThree uf3 = new UnionFindThree(size);
        System.out.println("UnionFindThree : " + testUF(uf3, m) + " s");

        UnionFindFour uf4 = new UnionFindFour(size);
        System.out.println("UnionFindFour : " + testUF(uf4, m) + " s");

        UnionFindFive uf5 = new UnionFindFive(size);
        System.out.println("UnionFindFive : " + testUF(uf5, m) + " s");

        UnionFindSix uf6 = new UnionFindSix(size); // 递归时间消耗相对大，空间开销大
        System.out.println("UnionFindFive : " + testUF(uf6, m) + " s");
    }
}
