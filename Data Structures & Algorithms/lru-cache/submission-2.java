
class LRUCache {
    // 1. Define the Doubly Linked List Node
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache; // The Hash Table shortcut
    private Node head; // Points to the Most Recently Used
    private Node tail; // Points to the Least Recently Used (Eldest)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        // Initialize dummy head and tail to avoid null checks
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            // Move node to the front (Most Recently Used)
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Remove the old node if updating an existing key
            remove(cache.get(key));
        }
        
        // Create new node and add it to map and list
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);
        
        // If we exceed capacity, evict the eldest (node right before dummy tail)
        if (cache.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    // Helper: Removes a node from the doubly linked list (O(1))
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: Inserts a node right after the dummy head (O(1))
    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}