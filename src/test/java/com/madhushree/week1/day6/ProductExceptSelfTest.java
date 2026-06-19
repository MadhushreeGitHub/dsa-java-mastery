package com.madhushree.week1.day6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductExceptSelfTest {

    private ProductExceptSelf productExceptSelf = new ProductExceptSelf();

    // ============================================
    // Tests for productExceptSelf method
    // ============================================

    /**
     * Test case 1: Simple positive numbers
     * Input: [1, 2, 3, 4]
     * Expected Output: [24, 12, 8, 6]
     */
    @Test
    void testProductExceptSelfWithPositiveNumbers() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        int[] result = productExceptSelf.productExceptSelf(nums);
        assertArrayEquals(expected, result);
    }

    /**
     * Test case 2: Mixed numbers with zero
     * Input: [-1, 1, 0, -3, 3]
     * Expected Output: [0, 0, 9, 0, 0]
     */
    @Test
    void testProductExceptSelfWithMixedNumbersAndZero() {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] expected = {0, 0, 9, 0, 0};
        int[] result = productExceptSelf.productExceptSelf(nums);
        assertArrayEquals(expected, result);
    }

    /**
     * Test case 3: All positive numbers
     * Input: [2, 3, 4, 5]
     * Expected Output: [60, 40, 30, 24]
     */
    @Test
    void testProductExceptSelfAllPositive() {
        int[] nums = {2, 3, 4, 5};
        int[] expected = {60, 40, 30, 24};
        int[] result = productExceptSelf.productExceptSelf(nums);
        assertArrayEquals(expected, result);
    }

    /**
     * Test case 4: Two elements
     * Input: [1, 2]
     * Expected Output: [2, 1]
     */
    @Test
    void testProductExceptSelfTwoElements() {
        int[] nums = {1, 2};
        int[] expected = {2, 1};
        int[] result = productExceptSelf.productExceptSelf(nums);
        assertArrayEquals(expected, result);
    }

    /**
     * Test case 5: With negative numbers
     * Input: [-1, -2, -3]
     * Expected Output: [6, 3, 2]
     */
    @Test
    void testProductExceptSelfWithNegativeNumbers() {
        int[] nums = {-1, -2, -3};
        int[] expected = {6, 3, 2};
        int[] result = productExceptSelf.productExceptSelf(nums);
        assertArrayEquals(expected, result);
    }

    /**
     * Test case 6: Single zero in array
     * Input: [1, 2, 0, 4]
     * Expected Output: [0, 0, 8, 0]
     */
    @Test
    void testProductExceptSelfWithSingleZero() {
        int[] nums = {1, 2, 0, 4};
        int[] expected = {0, 0, 8, 0};
        int[] result = productExceptSelf.productExceptSelf(nums);
        assertArrayEquals(expected, result);
    }

    /**
     * Test case 7: Multiple zeros
     * Input: [0, 0, 3, 4]
     * Expected Output: [0, 0, 0, 0]
     */
    @Test
    void testProductExceptSelfWithMultipleZeros() {
        int[] nums = {0, 0, 3, 4};
        int[] expected = {0, 0, 0, 0};
        int[] result = productExceptSelf.productExceptSelf(nums);
        assertArrayEquals(expected, result);
    }

    // ============================================
    // Tests for productExceptSelfOptimized method
    // ============================================

    /**
     * Test case 1 (Optimized): Simple positive numbers
     * Input: [1, 2, 3, 4]
     * Expected Output: [24, 12, 8, 6]
     */
    @Test
    void testProductExceptSelfOptimizedWithPositiveNumbers() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        int[] result = productExceptSelf.productExceptSelfOptimized(nums);
        assertArrayEquals(expected, result);
    }

    /**
     * Test case 2 (Optimized): Mixed numbers with zero
     * Input: [-1, 1, 0, -3, 3]
     * Expected Output: [0, 0, 9, 0, 0]
     */
    @Test
    void testProductExceptSelfOptimizedWithMixedNumbersAndZero() {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] expected = {0, 0, 9, 0, 0};
        int[] result = productExceptSelf.productExceptSelfOptimized(nums);
        assertArrayEquals(expected, result);
    }

    /**
     * Test case 3 (Optimized): All positive numbers
     * Input: [2, 3, 4, 5]
     * Expected Output: [60, 40, 30, 24]
     */
    @Test
    void testProductExceptSelfOptimizedAllPositive() {
        int[] nums = {2, 3, 4, 5};
        int[] expected = {60, 40, 30, 24};
        int[] result = productExceptSelf.productExceptSelfOptimized(nums);
        assertArrayEquals(expected, result);
    }

    /**
     * Test case 4 (Optimized): Two elements
     * Input: [1, 2]
     * Expected Output: [2, 1]
     */
    @Test
    void testProductExceptSelfOptimizedTwoElements() {
        int[] nums = {1, 2};
        int[] expected = {2, 1};
        int[] result = productExceptSelf.productExceptSelfOptimized(nums);
        assertArrayEquals(expected, result);
    }

    /**
     * Test case 5 (Optimized): With negative numbers
     * Input: [-1, -2, -3]
     * Expected Output: [6, 3, 2]
     */
    @Test
    void testProductExceptSelfOptimizedWithNegativeNumbers() {
        int[] nums = {-1, -2, -3};
        int[] expected = {6, 3, 2};
        int[] result = productExceptSelf.productExceptSelfOptimized(nums);
        assertArrayEquals(expected, result);
    }

    /**
     * Test case 6 (Optimized): Single zero in array
     * Input: [1, 2, 0, 4]
     * Expected Output: [0, 0, 8, 0]
     */
    @Test
    void testProductExceptSelfOptimizedWithSingleZero() {
        int[] nums = {1, 2, 0, 4};
        int[] expected = {0, 0, 8, 0};
        int[] result = productExceptSelf.productExceptSelfOptimized(nums);
        assertArrayEquals(expected, result);
    }

    /**
     * Test case 7 (Optimized): Multiple zeros
     * Input: [0, 0, 3, 4]
     * Expected Output: [0, 0, 0, 0]
     */
    @Test
    void testProductExceptSelfOptimizedWithMultipleZeros() {
        int[] nums = {0, 0, 3, 4};
        int[] expected = {0, 0, 0, 0};
        int[] result = productExceptSelf.productExceptSelfOptimized(nums);
        assertArrayEquals(expected, result);
    }
}
