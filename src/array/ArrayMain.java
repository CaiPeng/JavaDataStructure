package array;

public class ArrayMain {

    public static void main(String[] args) {
//        DynamicArray array = new DynamicArray(10);
//        for (int i = 0; i < 10; i++) {
//            array.addLast(i);
//        }
//
//        System.out.println(array.toString());
//
//        for (int i = 0; i < 10; i++) {
//            array.addLast(i);
//        }
//
//        System.out.println(array.toString());
//
//
//        array.remove(0);
//        System.out.println(array.toString());

        //时间复杂度分析

        //大O 描述的是算法的运行时间和输入数据的关系
        //eg1

        //O(n)  n在程序中代表的含义不一样  goto: eg1


    }

    /**
     * eg1  O(n) n为nums中元素个数 算法和n成线性关系
     * 为什么要用大O，叫做O(n)  忽略很多常数，T =  c1 * n + c2
     * c1 是执行一次的时间
     *
     * @param nums 数组
     * @return 数组求和
     */
    public static int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }


}
