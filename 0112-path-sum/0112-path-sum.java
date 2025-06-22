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
class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        return hasPathSumWorker(root,targetSum);
    }
    
    public boolean hasPathSumWorker(TreeNode root, int targetSum) {
        if(root.left == null && root.right == null){
            return targetSum-root.val == 0;
        }

        boolean a=false,b=false;

        if(root.left != null){
            a = hasPathSumWorker(root.left,targetSum-root.val);
        }

        if(root.right != null){
            b = hasPathSumWorker(root.right,targetSum-root.val);        
        }

        return a || b;

    }
}