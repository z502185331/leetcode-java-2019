class Solution {
    public boolean canConstruct1(String ransomNote, String magazine) {
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
    
    public boolean canConstruct(String ransomNote, String magazine) {
        int counts[] = new int[26]; 
        for (char c : magazine.toCharArray()) {
            counts[(int)c - (int)'a'] += 1;    
        }
        
        for (char c: ransomNote.toCharArray()) {
            counts[(int)c - (int)'a'] -= 1;
            
            if (counts[(int)c - (int)'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }
}
