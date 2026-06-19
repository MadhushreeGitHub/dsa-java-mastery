package com.madhushree.week1.day6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums){
        int[] preFixMap = new int[nums.length];
        int[] postFixMap = new int[nums.length];
        preFixMap[0] = 1;
        postFixMap[nums.length -1] = 1;
       for(int i = 1; i < nums.length; i++){

              preFixMap[i] = preFixMap[i-1] * nums[i-1];
       }
       for(int i = nums.length-2; i >= 0 ; i--){

           postFixMap[i] = postFixMap[i+1] * nums[i+1];

       }
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = preFixMap[i] * postFixMap[i];
        }
        return result;
    }

    public int[] productExceptSelfOptimized(int[] nums){
        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i = 1; i < nums.length; i++){
            result[i] = result[i-1] * nums[i-1];
        }
        int postFix = 1;
        for(int i = nums.length-1; i >= 0; i--){
            result[i] = result[i] * postFix;
            postFix *= nums[i];
        }


        return result;
    }
}



