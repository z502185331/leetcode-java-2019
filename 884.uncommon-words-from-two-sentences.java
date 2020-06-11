class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] wordA = A.split(" ");
        String[] wordB = B.split(" ");
        
        Map<String, Integer> count = new HashMap<>();
        
        countWord(wordA, count);
        countWord(wordB, count);
        
        List<String> res = new ArrayList<>();
        for (String word : count.keySet()) {
            if (count.get(word) == 1) {
                res.add(word);
            }
        }
        
        return res.toArray(new String[0]);
    }
    
    private void countWord(String[] words, Map<String, Integer> count) {
        for (String word : words) {
            if (!count.containsKey(word)) {
                count.put(word, 0);
            }
            
            count.put(word, count.get(word) + 1);
        }
        
    }
}
