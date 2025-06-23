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
    int maxVal;
    public int maxPathSum(TreeNode root) {
        maxVal=Integer.MIN_VALUE;
        maxPathSumWorker(root);
        return maxVal;
    }

    private int maxPathSumWorker(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(0,maxPathSumWorker(root.left));
        int right = Math.max(0,maxPathSumWorker(root.right));
        maxVal = Math.max(maxVal,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}