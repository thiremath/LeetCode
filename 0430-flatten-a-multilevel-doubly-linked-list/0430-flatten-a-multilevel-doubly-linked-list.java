/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node root = head;
        flattenWorker(root);
        return head;
    }

    public Node flattenWorker(Node root){
        if(root == null){
            return root;
        }

        Node nextNode = root.next;

        if(root.child != null){
            root.next = root.child;
            root.child = null;
            root.next.prev = root;
            Node lastchildNode = flattenWorker(root.next);
            lastchildNode.next = nextNode;
            if(nextNode!=null){
                nextNode.prev = lastchildNode;
            }
            else{
                return lastchildNode;
            }
        }

        if(nextNode!=null){
            return flattenWorker(nextNode);
        }

        return root;
    }
}