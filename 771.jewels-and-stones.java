/*
 * @lc app=leetcode id=771 lang=java
 *
 * [771] Jewels and Stones
 *
 * https://leetcode.com/problems/jewels-and-stones/description/
 *
 * algorithms
 * Easy (83.45%)
 * Total Accepted:    387.4K
 * Total Submissions: 458.2K
 * Testcase Example:  '"aA"\n"aAAbbbb"'
 *
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have.  Each character in S is a type of stone
 * you have.  You want to know how many of the stones you have are also
 * jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type
 * of stone from "A".
 *
 * Example 1:
 *
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 *
 *
 * Example 2:
 *
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 *
 *
 * Note:
 *
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 *
 *
 */
 class Solution {
     public int numJewelsInStones(String J, String S) {
         int count = 0;
         Set<Character> js = new HashSet<>();

         for (char c : J.toCharArray()) {
             js.add(c);
         }

         for (char c : S.toCharArray()) {
             if (js.contains(c)) {
                 count++;
             }
         }

         return count;
     }
 }
