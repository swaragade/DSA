package io.swaragade;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class TwoSum {
    // https://leetcode.com/problems/two-sum/
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int[] inputArr = new int[n];
        for (int i = 0; i < n; i++) {
            inputArr[i] = fr.nextInt();
        }
        int target = fr.nextInt();
        int[] ans = twoSum(inputArr, target);
        out.println(ans[0] + " | " + ans[1]);
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (cache.containsKey(remainder)) {
                return new int[]{cache.get(remainder), i};
            } else {
                cache.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
    }

    /*
     *  Normal approach
     */
    static int[] twoSumBrute(int[] nums, int target) {
        int ptr1 = 0;
        int ptr2 = ptr1 + 1;
        while (ptr1 < nums.length - 1) {
            if (nums[ptr1] + nums[ptr2] == target) {
                return new int[]{ptr1, ptr2};
            } else {
                if (ptr2 != nums.length - 1) {
                    ptr2++;
                } else {
                    ptr1++;
                    ptr2 = ptr1 + 1;

                }
            }
        }
        return new int[]{ptr1, ptr2};
    }
}
