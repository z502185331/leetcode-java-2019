/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (33.96%)
 * Total Accepted:    648.1K
 * Total Submissions: 1.9M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 *
 * Example 2:
 *
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 *
 */
 class Solution {
     public String longestCommonPrefix(String[] strs) {
         if (strs.length == 0) {
             return "";
         }

         StringBuilder sb = new StringBuilder();

         int length = strs.length;

         int strIndex = 0;
         int curIndex = 0;
         char prevLetter = ' ';

         while (true) {
             String str = strs[curIndex % length];

             if (strIndex >= str.length()) {
                 break;
             }

             char curLetter = str.charAt(strIndex);

             // When iterating the first item
             if (curIndex % length == 0) {
                 prevLetter = curLetter;

             } else if (prevLetter != curLetter) {
                 break;
             }

             // When iterating the last item
             if (curIndex % length == length - 1) {
                 sb.append(prevLetter);
                 strIndex++;
             }

             curIndex++;
         }

         return sb.toString();
     }
 }
