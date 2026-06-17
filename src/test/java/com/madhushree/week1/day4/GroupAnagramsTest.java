package com.madhushree.week1.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GroupAnagramsTest {
    @Test
    void anagram_returnsTrue() {
        assertEquals(3, GroupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).size());
    }
    @Test
    void anagram_returnsFalse() {
        assertEquals(1, GroupAnagrams.groupAnagrams(new String[]{"a"}).size());
    }
    @Test
    void anagram_returnsFalse2() {
        assertEquals(1, GroupAnagrams.groupAnagrams(new String[]{""}).size());
    }
    @Test
    void anagram_returnsFalse3() {
        assertEquals(1, GroupAnagrams.groupAnagrams(new String[]{"abc","abc","abc"}).size());
    }
    @Test
    void anagram_returnsFalse4() {
        assertEquals(3, GroupAnagrams.groupAnagrams(new String[]{"abc","def","ghi"}).size());
    }




}
