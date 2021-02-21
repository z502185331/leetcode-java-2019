class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (!count.containsKey(c)) {
                count.put(c, 0);
            }
            
            count.put(c, count.get(c) + 1);
        }
        
        for (char c: ransomNote.toCharArray()) {
            if (!count.containsKey(c) || count.get(c) == 0) {
                return false;
            } 
            
            count.put(c, count.get(c) - 1);
        }
        
        return true;
    }
}383
