class Solution {
    
    // O(n ^ 2)
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        
        // Build the index map
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            indexMap.put(nums2[i], i);
        }
        
        for (int i = 0; i < nums1.length; i++) {
            int target = nums1[i];
            res[i] = -1;
            
            for (int j = indexMap.get(target); j < nums2.length; j++) {
                if (nums2[j] > target) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        
        return res;
    }
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> maxMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                maxMap.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = maxMap.getOrDefault(nums1[i], -1);
        }
        
        return res;
    }
}
