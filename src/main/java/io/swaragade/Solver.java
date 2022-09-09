package io.swaragade;

import static java.lang.System.out;
import static java.lang.System.err;

import io.swaragade.FastReader;

import java.io.FileNotFoundException;

// cmd + option + L : format code

public class Solver {
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
        int ptr1 = 0;
        int ptr2 = ptr1 + 1;
        while (ptr1 < nums.length-1) {
            if (nums[ptr1] + nums[ptr2] == target) {
                return new int[]{ptr1, ptr2};
            } else {
                if (ptr2 != nums.length -1) {
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
