/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (37.02%)
 * Total Accepted:    874.7K
 * Total Submissions: 2.3M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 *
 * Input: "()"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: "()[]{}"
 * Output: true
 *
 *
 * Example 3:
 *
 *
 * Input: "(]"
 * Output: false
 *
 *
 * Example 4:
 *
 *
 * Input: "([)]"
 * Output: false
 *
 *
 * Example 5:
 *
 *
 * Input: "{[]}"
 * Output: true
 *
 *
 */
 class Solution {
     public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();

         for (char c : s.toCharArray()) {
             if (c == '{' || c == '[' || c == '(') {
                 stack.push(c);
             } else {
                 if (stack.isEmpty() || !inPair(stack.pop(), c)) {
                     return false;
                 }
             }
         }

         return stack.isEmpty();
     }

     private boolean inPair(char c1, char c2) {
         return (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']') || (c1 == '(' && c2 == ')');
     }
 }
