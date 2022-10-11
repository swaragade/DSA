package io.swaragade;

// cmd + option + L : format code

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        // https://leetcode.com/problems/group-anagrams/description/
        new GroupAnagram().groupAnagrams(new String[]{"", ""});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalAnagramList = new ArrayList<>();
        Map<List, List> store = new HashMap<>();

        for(String s : strs){
            Integer[] key = new Integer[26];
            Arrays.fill(key, 0);
            for(Character c : s.toCharArray()){
                key[c - 'a'] = key[c- 'a'] + 1;
            }
            List<Integer> finalKey = Arrays.asList(key);
            List<String> value = store.getOrDefault(finalKey, new ArrayList<String>());
            value.add(s);
            store.put(finalKey, value);
        }

        for(List l : store.values()){
            finalAnagramList.add(l);
        }
        return finalAnagramList;
    }
}
