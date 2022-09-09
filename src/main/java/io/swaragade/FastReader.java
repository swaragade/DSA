package io.swaragade;

import java.io.*;
import java.util.StringTokenizer;

public class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
//        br = new BufferedReader(
//                new InputStreamReader(System.in));
        br=new BufferedReader(new
                InputStreamReader(getClass().getClassLoader().getResourceAsStream("input.txt")));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}