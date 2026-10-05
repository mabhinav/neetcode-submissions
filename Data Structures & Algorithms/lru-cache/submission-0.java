class LRUCache {
    private static class Node {
        int key;
        int value;
        Node prev = null;
        Node next = null;

        Node(){}
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Node head;
    private final Node tail;
    private final Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.map = new HashMap<>();   
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        applyAccess(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node existing = map.get(key);
        if (existing != null) {
            existing.value = value;
            applyAccess(existing);
            return;
        }
        
        if (map.size() == capacity) {
            Node victim = tail.prev;
            map.remove(victim.key);
            removeNode(victim);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        applyAccess(node);
    }

    private void applyAccess(Node node) {
        if (node.next != null && node.prev != null) {
            removeNode(node);
        }
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
