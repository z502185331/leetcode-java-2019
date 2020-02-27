/*
 * @lc app=leetcode id=946 lang=java
 *
 * [946] Validate Stack Sequences
 *
 * https://leetcode.com/problems/validate-stack-sequences/description/
 *
 * algorithms
 * Medium (58.28%)
 * Total Accepted:    25.5K
 * Total Submissions: 43.4K
 * Testcase Example:  '[1,2,3,4,5]\n[4,5,3,2,1]'
 *
 * Given two sequences pushed and popped with distinct values, return true if
 * and only if this could have been the result of a sequence of push and pop
 * operations on an initially empty stack.
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 *
 *
 * Example 2:
 *
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 *
 *
 *
 *
 * Note:
 *
 *
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed is a permutation of popped.
 * pushed and popped have distinct values.
 *
 *
 *
 */
 class Solution {
     public boolean validateStackSequences(int[] pushed, int[] popped) {
         if (pushed.length == 0) {
             return pushed.length == popped.length;
         }

         Stack<Integer> stack = new Stack<>();
         int poppedCount = 0;

         for (int num : pushed) {
             stack.push(num);

             while (!stack.isEmpty() && poppedCount < pushed.length && popped[poppedCount] == stack.peek()) {
                 stack.pop();
                 poppedCount++;
             }
         }

         return poppedCount == pushed.length;
     }
 }
