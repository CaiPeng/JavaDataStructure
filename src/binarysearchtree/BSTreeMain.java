package binarysearchtree;

public class BSTreeMain {

    public static void main(String[] args){
        BSTree<Integer> bsTree = new BSTree<>();
        int[] nums = {5,3,6,8,4,2};
        for (int i = 0; i < nums.length; i++) {
            bsTree.add(nums[i]);
        }
//        bsTree.inOrder();

        bsTree.postOrder();
//        System.out.println(bsTree.toString());

    }
}
