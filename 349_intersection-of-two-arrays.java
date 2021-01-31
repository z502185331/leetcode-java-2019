class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> resSet = new HashSet<>();
        
        for (int num : nums2) {
            if (nums1Set.contains(num)) {
                resSet.add(num);
            }
        }
        
        int res[] = new int[resSet.size()];
        int i = 0;
        for (int num : resSet) {
            res[i++] = num;
        }
        
        return res;
    }
}
