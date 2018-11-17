package linkedlist;

import recursion.linkedlist_issue_in_leetcode.ListNode;

import java.util.HashMap;


public class LinkedListMain {

    public static void main(String[] args) {
//        TestStack testStack = new TestStack();
//        double arrayStackTime = testStack.testStack(new ArrayStack<Integer>(), 100000);
//        System.out.println("ArrayStackTime " + arrayStackTime);
//        double listStackTime = testStack.testStack(new LinkedListStack<>(), 100000);
//        System.out.println("ListStackTime " + listStackTime);
//
        int[] ints = get(new int[]{3, 2, 4}, 6);
        System.out.println("ArrayStackTime " + ints);
    }

    public static int[] get(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode l1Pre = l1;
        ListNode l2Pre = l1;

        ListNode l3 = new ListNode(-1);

        while (l1Pre != null || l2Pre != null) {
            sum = sum / 10;
            if (l1Pre != null) {
                sum += l1Pre.val;
                l1Pre = l1Pre.next;
            }

            if (l2Pre != null) {
                sum += l2Pre.val;
                l2Pre = l2Pre.next;
            }

            ListNode node = new ListNode(sum % 10);

            l3.next = node;
        }
        return l3.next;
    }

}
