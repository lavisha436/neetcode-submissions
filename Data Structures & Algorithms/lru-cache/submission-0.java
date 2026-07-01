class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key , int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer,Node> map;
    Node dummyHead;
    Node dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dummyHead = new Node(-1 , -1);
        dummyTail = new Node(-1 , -1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    void addNode(Node node){
        node.prev = dummyTail.prev;
        node.next = dummyTail;
        dummyTail.prev.next = node;
        dummyTail.prev = node;
    }


    void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
    }
    
    public void put(int key, int val) {
        // case 1 = key exist
        if(map.containsKey(key)){
        Node node = map.get(key);
        removeNode(node);
        node.val = val;
        addNode(node);
        return;
        }
        // cache full
        if(map.size() == capacity){
            Node lru = dummyHead.next;
            removeNode(lru); //remove from dll
            map.remove(lru.key); //remove frome map
        }
        //make new node
        Node node = new Node(key , val);
        addNode(node);
        map.put(key,node);
    }
}
