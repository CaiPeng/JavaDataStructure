package array.heap.priorityqueue;


import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * 在N个元素中选出前M个元素 M<<N
 * <p>
 * 1.排序 NLogN
 * <p>
 * 2.优先队列NLogM
 * 优先队列 维护当前看到的前M个元素 最小堆
 * <p>
 * 用最大堆（优先队列 小的优先）
 */
public class IssueSelectLargestN {

    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (freq < another.freq) {
                return 1;
            } else if (freq > another.freq) {
                return -1;
            } else {
                return 0;
            }
        }
    }


    public List<Integer> topKFrequentSolution1(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>(); //元素 频次
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        PriorityQueue<Freq> freqPriorityQueue = new PriorityQueue<>();

        //O(nLogK)
        for (int key : map.keySet()) {
            if (freqPriorityQueue.getSize() < k) {
                freqPriorityQueue.enqueue(new Freq(key, map.get(key)));
            } else if (map.get(key) > freqPriorityQueue.getFront().freq) {
                freqPriorityQueue.dequeue();
                freqPriorityQueue.enqueue(new Freq(key, map.get(key)));
            }
        }

        List<Integer> res = new LinkedList<>();
        while (!freqPriorityQueue.isEmpty()) {
            res.add(freqPriorityQueue.dequeue().e);
        }
        return res;
    }

    public static void main(String[] args) {
        IssueSelectLargestN issueSelectLargestN = new IssueSelectLargestN();
        List<Integer> integers = issueSelectLargestN.topKFrequentSolution1(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }

}
