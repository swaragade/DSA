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
    }
}
