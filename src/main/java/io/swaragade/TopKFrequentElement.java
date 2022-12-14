package io.swaragade;

// cmd + option + L : format code

import java.util.*;

public class TopKFrequentElement {
    // https://leetcode.com/problems/top-k-frequent-elements/description/
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int k = fr.nextInt();
        int n = fr.nextInt();
        int[] inputArr = new int[n];
        for (int i = 0; i < n; i++) {
            inputArr[i] = fr.nextInt();
        }
        System.out.println(Arrays.toString(new TopKFrequentElement().topKFrequent(inputArr, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        //Collections.reverseOrder()
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue().compareTo(b.getValue()));
        Map<Integer, Integer> store = new HashMap<>();
        for (int i : nums) {
            store.put(i, store.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> it : store.entrySet()) {
            heap.add(it);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] arr = new int[k];
        int i = k - 1;
        while (!heap.isEmpty()) {
            arr[i--] = heap.poll().getKey();
        }
        return arr;
    }

}
