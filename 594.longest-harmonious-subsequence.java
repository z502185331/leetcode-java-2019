class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        
        int low = nums[0];
        int high = nums[0];
        for (int num: nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 0);
                
                low = Math.min(low, num);
                high = Math.max(high, num);
            }
            
            counts.put(num, counts.get(num) + 1);
        }
        
        int len = 0;
        for (int i : counts.keySet()) {
            if (counts.containsKey(i) && counts.containsKey(i + 1)) {
                len = Math.max(len, counts.get(i) + counts.get(i + 1));
            }
        }
        
        return len;
    }
}
