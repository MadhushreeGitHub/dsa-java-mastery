package com.madhushree.week1.day5;

import java.util.*;

public class TopKFrequent {
    public static int[] topKFrequent2(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.merge(num, 1, Integer::sum);
        }
/** This also a alternate way to compare the values in the map and sort them in reverse order. We can use either of the two approaches.
        return map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();*/

        return map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry<Integer,Integer>::getValue).reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();


    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] frequencyBuckets = new List[nums.length + 1];     // index = frequency, value = list of numbers with that frequency
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int index = 0;
        for (Map.Entry<Integer, Integer> currEntry : map.entrySet()) {
            if (frequencyBuckets[currEntry.getValue()] == null) {
                frequencyBuckets[currEntry.getValue()] = new ArrayList<>();
            }
            frequencyBuckets[currEntry.getValue()].add(currEntry.getKey());
        }

            int[] result = new int[k];

            for (int i = frequencyBuckets.length - 1; i >= 1 && index < k; i--) {
                if (frequencyBuckets[i] == null) continue;          // sparse
                for (int num : frequencyBuckets[i]) {
                    result[index++] = num;
                    if (index == k) break;                 // inner break is enough: outer guard `index < k` stops it
                }


            }

        return result;


    }
}
