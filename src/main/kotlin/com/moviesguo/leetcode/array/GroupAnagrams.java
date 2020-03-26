package com.moviesguo.leetcode.array;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:
 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 */
public class GroupAnagrams {

    public static void main(String[] args){
        String a = "abc";
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length==0||strs==null) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String value = String.valueOf(chars);
            if (!map.containsKey(value)) map.put(value, new ArrayList<>());
            map.get(value).add(str);
        }
        return new ArrayList<>(map.values());
    }


    /*
    通过ascii码不行, "abc" 和 "`bd" 是一样的
     */
    public static int stringToAscii(String string) {
        int ascii = 0;
        for (int i = 0; i < string.length(); i++) {
            ascii += string.charAt(i);
        }
        return ascii;
    }

}
