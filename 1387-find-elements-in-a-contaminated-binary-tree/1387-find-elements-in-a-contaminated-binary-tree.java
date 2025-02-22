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
class FindElements {

    TreeNode curr;
    HashSet<Integer> set;
    Queue<TreeNode> queue;

    public FindElements(TreeNode root) {
        curr = root;
        queue = new LinkedList<>();
        set = new HashSet<>();

        curr.val = 0;
        queue.add(curr);

        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            set.add(temp.val);
            if(temp.left != null){
                temp.left.val = 1+2*temp.val;
                queue.add(temp.left);
            }
            if(temp.right != null){
                temp.right.val = 2+2*temp.val;
                queue.add(temp.right);
            }
        }
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */