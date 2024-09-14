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
    int ans=0;
    public int sumNumbers(TreeNode root) {
        sumNumbersWorker(root,0);
        return ans;
    }

    public void sumNumbersWorker(TreeNode root, int curr){
        if(root.left == null && root.right == null){
            ans += curr*10 + root.val;
        }

        if(root.left != null){
            sumNumbersWorker(root.left,curr*10+root.val);
        }

        if(root.right != null){
            sumNumbersWorker(root.right,curr*10+root.val);
        }

    }
}