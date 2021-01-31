class Solution {
    // Sorting 
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        Integer[] array = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(array, new Comparator<Integer>(){
            
            @Override
            public int compare(Integer a, Integer b) {
                boolean cond1 = Math.abs(a - x) < Math.abs(b - x);
                boolean cond2 = (Math.abs(a - x) == Math.abs(b - x)) && a < b;
                
                if (cond1 || cond2) {
                    return -1;
                } else if (a == b) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        
        List<Integer> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            res.add(array[i]);
        }
        
        Collections.sort(res);
        return res;
    }
    
    // Binary Search
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> array = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        if (x <= array.get(0)) {
            return array.subList(0, k);
        }
        
        if (x >= array.get(array.size() - 1)) {
            return array.subList(array.size() - k, array.size());
        }
        
        // Try to find the closest number to x
        int low = 0; 
        int high = array.size();
        
        while (low + 1 < high) {
            int middle = low + (high - low) / 2;
            int val = array.get(middle);
            
            if (val == x) {
                high = middle;
                break;
            } else if (val > x) {
                high = middle;
            } else {
                low = middle;
            }
        }
        
        int target = Math.abs(array.get(high) - x) >= Math.abs(array.get(low) - x) ? low : high;
        
        // Shrinking the range between [target - k + 1, target + k - 1] and 
        // try to find the closest k values
        int i = Math.max(0, target - k + 1);
        int j = Math.min(array.size() - 1, target + k - 1);
        
        while (j - i + 1 > k) {
            if (Math.abs(array.get(i) - x) > Math.abs(array.get(j) - x)) {
                i++;
            } else {
                j--;    
            }
        }
        
        return array.subList(i, j + 1);
    }
}
