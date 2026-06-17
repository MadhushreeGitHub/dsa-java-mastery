package com.madhushree.week1.day4;

import java.util.*;

public class GroupAnagrams {
    /**
     * Input["eat","tea","tan","ate","nat","bat"]
     * Output[["bat"],["nat","tan"],["ate","eat","tea"]]
     * @param strs
     * @return
     */

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new LinkedHashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }



    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}




