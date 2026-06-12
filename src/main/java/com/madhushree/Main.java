package com.madhushree;

import com.madhushree.week1.day1.TwoSum;
import java.util.*;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        TwoSum solver = new TwoSum();

        // ===== Test Case 1: Standard =====
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        Optional<int[]> result1 = solver.twoSum(nums1, target1);
        System.out.println("Test 1:");
        System.out.println("  Input: nums=" + Arrays.toString(nums1) + ", target=" + target1);
        result1.ifPresentOrElse(
                arr -> {
                    System.out.println("  Result: " + Arrays.toString(arr));
                    System.out.println("  Expected: [0, 1]");
                    int sumOfPair = IntStream.of(arr).map(i -> nums1[i]).sum();
                    boolean valid = sumOfPair == target1;
                    System.out.println("  Verification: " + sumOfPair + " == " + target1
                            + " ? " + (valid ? "✅" : "❌"));
                },
                () -> System.out.println("  Result: No pair found")
        );
        System.out.println();


        // ===== Test Case 2: Numbers not at start =====
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        Optional<int[]> result2 = solver.twoSum(nums2, target2);
        System.out.println("Test 2:");
        System.out.println("  Input: nums=" + Arrays.toString(nums2) + ", target=" + target2);
        result2.ifPresentOrElse(
                arr -> {
                    System.out.println("  Result: " + Arrays.toString(arr));
                    System.out.println("  Expected: [1, 2]");
                    int sumOfPair = IntStream.of(arr).map(i -> nums2[i]).sum();
                    boolean valid = sumOfPair == target2;
                    System.out.println("  Verification: " + sumOfPair + " == " + target2
                            + " ? " + (valid ? "✅" : "❌"));
                },
                () -> System.out.println("  Result: No pair found")
        );
        System.out.println();

        // ===== Test Case 3: Duplicates =====
        int[] nums3 = {3, 3};
        int target3 = 6;
        Optional<int[]> result3 = solver.twoSum(nums3, target3);
        System.out.println("Test 3:");
        System.out.println("  Input: nums=" + Arrays.toString(nums3) + ", target=" + target3);
        result3.ifPresentOrElse(
                arr -> {
                    System.out.println("  Result: " + Arrays.toString(arr));
                    System.out.println("  Expected: [0, 1]");
                    int sumOfPair = IntStream.of(arr).map(i -> nums3[i]).sum();
                    boolean valid = sumOfPair == target3;
                    System.out.println("  Verification: " + sumOfPair + " == " + target3
                            + " ? " + (valid ? "✅" : "❌"));
                },
                () -> System.out.println("  Result: No pair found")
        );
        System.out.println();

        // ===== Test Case 4: No valid pair =====
        int[] nums4 = {1, 2, 3};
        int target4 = 100;
        Optional<int[]> result4 = solver.twoSum(nums4, target4);

        System.out.println("Test 4:");
        System.out.println("  Input: nums=" + Arrays.toString(nums4) + ", target=" + target4);

        result4.ifPresentOrElse(
                arr -> {
                    System.out.println("  Result: " + Arrays.toString(arr));
                    int sumOfPair = IntStream.of(arr).map(i -> nums4[i]).sum();
                    boolean valid = sumOfPair == target4;
                    System.out.println("  Verification: " + sumOfPair + " == " + target4
                            + " ? " + (valid ? "✅" : "❌"));
                },
                () -> System.out.println("  Result: No pair found (Optional was empty) ✅")
        );
    }

        /**System.out.println("Java version: " + System.getProperty("java.version"));

        // Java 16+ feature: record
        record Point(int x, int y) {}
        var p = new Point(3, 4);
        System.out.println(p);

        // Java 21 feature: pattern matching for switch
        Object obj = 42;
        String result = switch (obj) {
            case Integer i -> "Int: " + i;
            case String s -> "String: " + s;
            default -> "Other";
        };
        System.out.println(result);**/

}