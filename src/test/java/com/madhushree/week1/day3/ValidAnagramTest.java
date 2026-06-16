package com.madhushree.week1.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidAnagramTest {

    @Test
    void anagram_classic_returnsTrue() {
        assertTrue(ValidAnagram.isAnagram("anagram", "nagaram"));
    }

    @Test
    void differentCharacters_returnsFalse() {
        assertFalse(ValidAnagram.isAnagram("rat", "car"));
    }

    @Test
    void lengthMismatch_returnsFalse() {
        assertFalse(ValidAnagram.isAnagram("a", "ab"));
    }

    @Test
    void bothEmpty_returnsTrue() {
        assertTrue(ValidAnagram.isAnagram("", ""));
    }

    @Test
    void sameCharsDifferentFrequencies_returnsFalse() {
        assertFalse(ValidAnagram.isAnagram("aab", "abb"));
    }

    @Test
    void sameCharsOffByOneCounts_returnsFalse() {
        assertFalse(ValidAnagram.isAnagram("aacc", "ccac"));
    }
}