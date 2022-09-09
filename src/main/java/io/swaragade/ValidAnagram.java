package io.swaragade;

import java.util.*;

import static java.lang.System.out;

public class ValidAnagram {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        String s = fr.nextLine();
        String t = fr.nextLine();
        out.println(new ValidAnagram().isAnagramArray(s, t));
    }

//    with array
    public boolean isAnagramArray(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] store = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char curCharS = s.charAt(i);
            char curCharT = t.charAt(i);
            store[curCharS - 'a'] = store[curCharS - 'a']+1;
            store[curCharT - 'a'] = store[curCharT - 'a']-1;
        }
        for(int i : store){
            if ( i != 0){
                return false;
            }
        }
        return true;
    }
//    With HashMap
    public boolean isAnagramMap(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> store = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curCharS = s.charAt(i);
            char curCharT = t.charAt(i);
            store.put(curCharS, store.getOrDefault(curCharS, 0)+1);
            store.put(curCharT, store.getOrDefault(curCharT, 0)-1);
        }
        for(int i : store.values()){
            if ( i != 0){
                return false;
            }
        }
        return true;
    }

//    solution, takes extra memory and sorting
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] si = s.toCharArray();
        char[] ti = t.toCharArray();
        Arrays.sort(si);
        Arrays.sort(ti);
        for (int i = 0; i < si.length; i++) {
            if (si[i] != ti[i]){
                return false;
            }
        }
        return true;
    }
}


