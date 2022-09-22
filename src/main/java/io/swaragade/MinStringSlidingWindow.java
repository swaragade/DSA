package io.swaragade;

import java.util.*;

import static java.lang.System.out;

public class MinStringSlidingWindow {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        String s = fr.nextLine();
        String t = fr.nextLine();
        out.println(new MinStringSlidingWindow().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        Integer stIdx = 0;
        Integer endIdx = t.length();
        Map<Integer, String> store = new HashMap<>();
        List<String> subList = Arrays.asList(t.split(""));
        Collections.sort(subList);
        while (stIdx <= s.length() - t.length()) {
            String testStr = s.substring(stIdx, endIdx);
            if (isExists(testStr, subList)) {
                store.put(endIdx - stIdx, testStr);
                stIdx++;
                endIdx = stIdx + t.length();
            } else {
                if (endIdx < s.length()) {
                    endIdx++;
                } else {
                    stIdx++;
                    endIdx = stIdx + t.length();
                }
            }
        }
        Integer max = Integer.MAX_VALUE;
        for (Map.Entry<Integer, String> entry : store.entrySet()) {
            max = Integer.min(max, entry.getKey());
        }
        return store.getOrDefault(max, "");
    }

    Boolean isExists(String testStr, List<String> subList){
        List<String> testList = Arrays.asList(testStr.split(""));
        Collections.sort(testList);
        out.println(subList);
        out.println(testList);
        out.println("--------");
        int i = 0;
        int j = 0;
        while (i < subList.size() && j < testList.size()){
            if (subList.get(i).equals(testList.get(j))) {
                i++;j++;
                if (i == subList.size() && j == testList.size()){
                    return true;
                }
                else if (j == testList.size() && i < subList.size()){
                    return false;
                }else if (j < testList.size() && i == subList.size()){
                    return true;
                }
            }else{
                j++;
                if (j == testList.size() && i < subList.size()){
                    return false;
                }
                else if (j < testList.size() && i == subList.size()){
                    return false;
                }
            }
        }
        return null;
    }
}
