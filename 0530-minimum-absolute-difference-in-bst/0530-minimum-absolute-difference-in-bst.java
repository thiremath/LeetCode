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
    int prev = -1;
    public int getMinimumDifference(TreeNode root) {
        return inorder(root);
    }

    public int inorder(TreeNode root){
        int ans = Integer.MAX_VALUE;

        if(root.left != null){
            ans = inorder(root.left);
        }

        if(prev != -1){
            ans = Math.min(root.val-prev,ans);
        }

        prev = root.val;

        if(root.right != null){
            ans = Math.min(ans,inorder(root.right));
        }

        return ans;

    }
}