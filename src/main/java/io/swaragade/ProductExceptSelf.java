package io.swaragade;

// cmd + option + L : format code

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int[] inputArr = new int[n];
        for (int i = 0; i < n; i++) {
            inputArr[i] = fr.nextInt();
        }
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf(inputArr)));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int leftsum = 1;
        for (int i = 0; i < left.length; i++) {
            int prev_idx = i-1;
            if (prev_idx >= 0) {
                leftsum *= nums[prev_idx];
            }
            left[i] = leftsum;
        }
        int rightsum = 1;
        for (int i = right.length-1; i >=0; i--) {
            int prev_idx = i+1;
            if (prev_idx < right.length) {
                rightsum *= nums[prev_idx];
            }
            right[i] = rightsum;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public int[] productExceptSelfBruteForce(int[] nums) {
        // o(n^2)
        int cur_idx = 0;
        int[] result = new int[nums.length];
        while (cur_idx < nums.length) {
            int sum = 1;
            for (int i = 0; i < nums.length; i++) {
                if (i != cur_idx) {
                    sum *= nums[i];
                }
            }
            result[cur_idx++] = sum;
        }
        return result;
    }
}
