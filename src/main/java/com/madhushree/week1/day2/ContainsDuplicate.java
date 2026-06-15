package com.madhushree.week1.day2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Day 2 — Contains Duplicate (NeetCode 150, Arrays & Hashing, Easy)
 *
 * Given an integer array nums, return true if any value appears at least twice, else false.
 */

public class ContainsDuplicate {
    public static boolean checkDuplicate(int[] numbers){
        Set<Integer> set = new HashSet<>();
        //Java 8 working with anyMatch
        // return Arrays.stream(numbers).anyMatch(n -> !set.add(n));

        ///Java 8 working with anyMatch and parallel
        return Arrays.stream(numbers).parallel().anyMatch(x -> !set.add(x));
        /**
         * Using JAVA 7
         * for (int n : numbers) {
            if (!set.add(n)) return true;
        }
        return false;**/
    }

    public static void main(String[] args) {
        System.out.println(checkDuplicate(new int[]{1,2,4,4,5,6,7,8,9,10}));
        System.out.println(checkDuplicate(new int[]{2,2}));
        System.out.println(checkDuplicate(new int[]{1,2,3,4,6,7,8,10,10}));
        System.out.println(checkDuplicate(new int[]{1,2,3,4,6,7,8,10}));
        System.out.println(checkDuplicate(new int[]{10}));
    }
}
