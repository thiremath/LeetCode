/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    int iterator;
    List<Integer> nodeList;

    public BSTIterator(TreeNode root) {
        iterator = -1;
        nodeList = new ArrayList<>();
        inorder(root);
    }

    public void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            nodeList.add(root.val);
            inorder(root.right);
        }
    }
    
    public int next() {
        return nodeList.get(++iterator);
    }
    
    public boolean hasNext() {
        if(iterator+1 < nodeList.size()){
            return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */