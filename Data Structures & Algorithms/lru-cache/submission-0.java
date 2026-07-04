class LRUCache {
    //Doubly LinkedList
    class Node {
        int key ;
        int val;
        Node prev;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Map<Integer,Node> map = null;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
        // 1-2-3-null
    private void remove(Node  node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
        // head-1-2-3-4
    private void insert(Node node){
       
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        
    }


    public int get(int key) {
        if (map.containsKey(key)) {
                Node node =  map.get(key);
                remove(node);
                insert(node);
            return node.val;
        }
        else
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        Node newNode = new Node(key,value);
         map.put(key , newNode);
         insert(newNode);  
        if(map.size() >capacity){
            Node lru = tail.prev;
            map.remove(lru.key);
            remove(lru);
        }
    }
}
