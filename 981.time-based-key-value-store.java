class TimeMap {

    private Map<String, LinkedList<String>> map;
    
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new LinkedList<>());
        }
        
        List<String> vals = map.get(key);
        while (vals.size() <= timestamp) {
            vals.add("");
        }
        
        vals.set(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        
        List<String> vals = map.get(key);
        int target = Math.min(timestamp, vals.size() - 1);
        
        while (target > 0 && vals.get(target) == "") {
            target--;
        }
        
        return target > 0 ? vals.get(target) : "";
    }
}

class TimeMap1 {

    private Map<String, TreeMap<Integer, String>> map;
    
    /** Initialize your data structure here. */
    public TimeMap1() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        
        TreeMap<Integer, String> vals = map.get(key);
        Integer t = vals.floorKey(timestamp);
        return t == null ? "" : vals.get(t);
    }
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
