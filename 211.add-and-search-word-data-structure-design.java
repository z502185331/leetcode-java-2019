/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 *
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 *
 * algorithms
 * Medium (30.49%)
 * Total Accepted:    122.3K
 * Total Submissions: 392.5K
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * Design a data structure that supports the following two operations:
 *
 *
 * void addWord(word)
 * bool search(word)
 *
 *
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one
 * letter.
 *
 * Example:
 *
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 *
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 *
 */
 class WordDictionary {

     private TrieNode root;

     /** Initialize your data structure here. */
     public WordDictionary() {
         this.root = new TrieNode(' ');
     }

     /** Adds a word into the data structure. */
     public void addWord(String word) {
         addWordHelper(root, word, 0);
     }

     private void addWordHelper(TrieNode cur, String word, int index) {
         if (index == word.length()) {
             cur.isWord = true;
             return;
         }

         char curVal = word.charAt(index);
         TrieNode child = cur.children[curVal - 'a'];

         if (child == null) {
             child = new TrieNode(curVal);
             cur.children[curVal - 'a'] = child;
         }

         addWordHelper(child, word, index + 1);
     }

     /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
     public boolean search(String word) {
         return searchHelper(root, word, 0);
     }

     private boolean searchHelper(TrieNode cur, String word, int index) {
         if (index == word.length()) {
             return cur.isWord;
         }

         char curVal = word.charAt(index);

         if (curVal != '.') {
             TrieNode child = cur.children[curVal - 'a'];

             if (child == null) {
                 return false;
             }

             return searchHelper(child, word, index + 1);
         } else {
             for (TrieNode child : cur.children) {
                 if (child == null || !searchHelper(child, word, index + 1)) {
                     continue;
                 }

                 return true;
             }
         }

         return false;
     }

     class TrieNode {
         TrieNode[] children;
         boolean isWord;
         char val;

         public TrieNode(char val) {
             this.children = new TrieNode[26];
             this.isWord = false;
             this.val = val;
         }
     }
 }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
