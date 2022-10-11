package io.swaragade;

// cmd + option + L : format code

import java.util.*;
import java.util.stream.Collectors;

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

        Map<Integer, Integer> store = new HashMap<>();
        for (int i : nums) {
            store.put(i, store.getOrDefault(i, 0) + 1);
        }
        int[] sortStore = new int[nums.length];
        Arrays.fill(sortStore, 0);
        for(Integer key : store.keySet()){
            sortStore[store.get(key)] = key;
        }
        int[] fn = new int[k];
        for (int i = 0; i < k; i++) {
            fn[i] = sortStore.get(0);
        }
        return fn;
    }

}
