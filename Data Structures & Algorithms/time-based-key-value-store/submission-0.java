class TimeMap {

    private static class Node {
        int timestamp;
        String value;

        Node(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private final Map<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Node(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Node> list = map.get(key);
        if (list == null || list.isEmpty()) {
            return "";
        }

        int left = 0;
        int right = list.size() - 1;
        String ans = "";
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (list.get(mid).timestamp <= timestamp) {
                ans = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
