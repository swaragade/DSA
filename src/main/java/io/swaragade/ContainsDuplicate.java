package io.swaragade;

// cmd + option + L : format code

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class ContainsDuplicate {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int[] inputArr = new int[n];
        for (int i = 0; i < n; i++) {
            inputArr[i] = fr.nextInt();
        }
        System.out.println(new ContainsDuplicate().containsDuplicate(inputArr));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int num : nums) {
            uniques.add(num);
        }
        out.println(uniques.size());
        if (nums.length > uniques.size()) {
            return true;
        }
        return false;
    }
}
