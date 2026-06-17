package com.madhushree.week1.day3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ValidAnagram {


    public static boolean isValidAnagram(String s, String t){

        if(s.length() != t.length()){
            return false;
        }

       char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.merge(c, 1, Integer::sum);

        }
        for(int i = 0; i < t.length(); i++){
            int value = map.merge(t.charAt(i), -1, Integer::sum);
            if(value < 0){return  false;}
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isValidAnagram("aab","aab"));
        System.out.println(isValidAnagram("rat","car"));
        System.out.println(isValidAnagram("anagram","nagaram"));
        System.out.println(isValidAnagram("",""));
        System.out.println(isValidAnagram("a","ab"));
        System.out.println(isValidAnagram("aacc","ccac"));
        System.out.println("=====================");

        System.out.println(isAnagram ("aab","aab"));
        System.out.println(isAnagram ("rat","car"));
        System.out.println(isAnagram ("anagram","nagaram"));
        System.out.println(isAnagram ("",""));
        System.out.println(isAnagram ("a","ab"));
        System.out.println(isAnagram ("aacc","ccac"));
    }
}
