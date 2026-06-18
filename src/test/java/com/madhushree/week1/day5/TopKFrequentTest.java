package com.madhushree.week1.day5;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TopKFrequentTest {
    
    @Test
    public void topKFrequent_basicCase() {
        // Given: array [1,1,1,2,2,3] and k=2
        // Expected: top 2 frequent elements are 1 (appears 3 times) and 2 (appears 2 times)
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = TopKFrequent.topKFrequent(nums, k);
        
        assertNotNull(result);
        assertEquals(2, result.length);
        assertArrayContains(result, 1);
        assertArrayContains(result, 2);
    }

    @Test
    public void topKFrequent_kEqualsOne() {
        // Given: array [1,2,3,3,3] and k=1
        // Expected: [3] (most frequent element)
        int[] nums = {1, 2, 3, 3, 3};
        int k = 1;
        int[] result = TopKFrequent.topKFrequent(nums, k);
        
        assertEquals(1, result.length);
        assertEquals(3, result[0]);
    }

    @Test
    public void topKFrequent_allElementsSameFrequency() {
        // Given: array [1,2,3,4] and k=2 (all elements appear once)
        // Expected: any 2 elements
        int[] nums = {1, 2, 3, 4};
        int k = 2;
        int[] result = TopKFrequent.topKFrequent(nums, k);
        
        assertEquals(2, result.length);
    }

    @Test
    public void topKFrequent_singleElement() {
        // Given: array [5] and k=1
        // Expected: [5]
        int[] nums = {5};
        int k = 1;
        int[] result = TopKFrequent.topKFrequent(nums, k);
        
        assertEquals(1, result.length);
        assertEquals(5, result[0]);
    }

    @Test
    public void topKFrequent_negativeNumbers() {
        // Given: array [-1,-1,-1,0,0,1] and k=2
        // Expected: top 2 frequent elements are -1 and 0
        int[] nums = {-1, -1, -1, 0, 0, 1};
        int k = 2;
        int[] result = TopKFrequent.topKFrequent(nums, k);
        
        assertEquals(2, result.length);
        assertArrayContains(result, -1);
        assertArrayContains(result, 0);
    }

    @Test
    public void topKFrequent_kEqualsUniqueElements() {
        // Given: array [1,1,2,2,3] and k equals number of unique elements (3)
        // Expected: all unique elements
        int[] nums = {1, 1, 2, 2, 3};
        int k = 3;
        int[] result = TopKFrequent.topKFrequent(nums, k);
        
        assertEquals(3, result.length);
        assertArrayContains(result, 1);
        assertArrayContains(result, 2);
        assertArrayContains(result, 3);
    }

    @Test
    public void topKFrequent_largerArray() {
        // Given: larger array with varying frequencies and k=3
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5};
        int k = 3;
        int[] result = TopKFrequent.topKFrequent(nums, k);
        
        assertEquals(3, result.length);
        assertArrayContains(result, 3); // frequency 4
        assertArrayContains(result, 1); // frequency 3
        assertArrayContains(result, 4); // frequency 3
    }

    @Test
    public void topKFrequent_duplicateFrequencies() {
        // Given: array where multiple elements have same frequency
        int[] nums = {4, 4, 4, 1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = TopKFrequent.topKFrequent(nums, k);
        
        assertEquals(2, result.length);
        // Should contain elements with highest frequency (4 and 1, both appear 3 times)
        assertArrayContains(result, 4);
        assertArrayContains(result, 1);
    }

    // Helper method to check if array contains a value
    private void assertArrayContains(int[] array, int value) {
        boolean found = false;
        for (int num : array) {
            if (num == value) {
                found = true;
                break;
            }
        }
        assertTrue(found, "Array should contain value: " + value);
    }
}
