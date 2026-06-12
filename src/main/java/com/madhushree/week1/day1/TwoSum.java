package com.madhushree.week1.day1;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TwoSum {

    public Optional<int[]> twoSum(int[] numbers, int target){
        if(numbers==null || numbers.length==0){
            return Optional.empty();
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i< numbers.length; i++){

           if(map.containsKey(target- numbers[i])){
               return Optional.of(new int[]{map.get(target- numbers[i]),i});
           }
           map.put(numbers[i],i);
        }
        return Optional.empty();
    }
}
