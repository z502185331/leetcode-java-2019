/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (37.88%)
 * Total Accepted:    251.4K
 * Total Submissions: 648.7K
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 *
 * Example 1:
 *
 *
 * Input: s = "egg", t = "add"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 *
 *
 * Input: s = "paper", t = "title"
 * Output: true
 *
 * Note:
 * You may assume both s and t have the same length.
 *
 */
 class Solution {
     public boolean isIsomorphic(String s, String t) {

         char[] sc = s.toCharArray();
         char[] tc = t.toCharArray();

         Map<Character, Character> mappings = new HashMap<>();

         for (int i = 0; i < sc.length; i++) {
             char c1 = sc[i];
             char c2 = tc[i];

             if (mappings.containsKey(c1) && mappings.get(c1) != c2) {
                 return false;
             }

             if (!mappings.containsKey(c1) && mappings.containsValue(c2)) {
                 return false;
             }

             mappings.put(c1, c2);
         }

         return true;
     }
 }
