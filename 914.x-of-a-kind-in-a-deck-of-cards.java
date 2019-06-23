/*
 * @lc app=leetcode id=914 lang=java
 *
 * [914] X of a Kind in a Deck of Cards
 *
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/description/
 *
 * algorithms
 * Easy (34.05%)
 * Total Accepted:    19.4K
 * Total Submissions: 57K
 * Testcase Example:  '[1,2,3,4,4,3,2,1]'
 *
 * In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to
 * split the entire deck into 1 or more groups of cards, where:
 *
 *
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 *
 *
 *
 * Example 2:
 *
 *
 * Input: [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 *
 *
 *
 * Example 3:
 *
 *
 * Input: [1]
 * Output: false
 * Explanation: No possible partition.
 *
 *
 *
 * Example 4:
 *
 *
 * Input: [1,1]
 * Output: true
 * Explanation: Possible partition [1,1]
 *
 *
 *
 * Example 5:
 *
 *
 * Input: [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2]
 *
 *
 *
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
 class Solution {
     public boolean hasGroupsSizeX(int[] deck) {
         if (deck.length == 0) {
             return false;
         }

         Map<Integer, Integer> count = new HashMap<>();
         for (int num : deck) {
             count.putIfAbsent(num, 0);
             count.put(num, count.get(num) + 1);
         }

         // Find the number with minimal count
         int res = -1;

         for (int c : count.values()) {
             if (res == -1) {
                 res = c;
             } else {
                 res = gcd(res, c);
             }
         }

         return res >= 2;
     }

     public int gcd(int x, int y) {
         return x == 0 ? y : gcd(y%x, x);
     }
 }
