class Node{
    protected Node prev;
    protected Node next;
    private int key;
    private int value;

    Node(){
        this.prev=null;
        this.next=null;
        value = 0;
        key = 0;
    }

    Node(int keyIn,int valueIn){
        this.prev=null;
        this.next=null;
        key = keyIn;
        value = valueIn;
    }

    public int getValue(){
        return this.value;
    }

    public int getKey(){
        return this.key;
    }
}

class LRUCache {

    int currCapacity = 0;
    int capacityAllowed = 1;
    Map<Integer,Node> nodeMap = new HashMap<>();
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        currCapacity = 0;
        capacityAllowed = capacity;
        nodeMap = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }
    
    public int get(int key) {
        // if exists return value otherwise -1
        if(!nodeMap.containsKey(key)){
            return -1;
        }

        // remove node from linkedlist and append to beginning
        remove(nodeMap.get(key));
        addToBeginning(nodeMap.get(key));
        return nodeMap.get(key).getValue();
    }
    
    public void put(int key, int value) {
        // if key exists remove from hashmap and linkedlist
        if(nodeMap.containsKey(key)){
            remove(nodeMap.get(key));
            nodeMap.remove(key);
        }

        // create new entry in hashmap and append to beginning of ll
        nodeMap.put(key,new Node(key,value));
        addToBeginning(nodeMap.get(key));
    }

    public void remove(Node node){
        Node previous_node = node.prev;
        Node next_node = node.next;

        previous_node.next = next_node;
        next_node.prev = previous_node;
        currCapacity--;
    }

    public void addToBeginning(Node node){

        // System.out.println("addToBeginning "+node.getKey());

        if(currCapacity == capacityAllowed){
            // System.out.println("evicting "+tail.prev.getKey());
            nodeMap.remove(tail.prev.getKey());
            remove(tail.prev);
        }

        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;

        currCapacity++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);



h,t


 */

