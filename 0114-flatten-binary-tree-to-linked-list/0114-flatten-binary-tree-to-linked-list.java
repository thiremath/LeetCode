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
    public void flatten(TreeNode root) {
        if(root != null){
            flattenWorker(root);
        }
    }

    public TreeNode flattenWorker(TreeNode root){

        TreeNode rightNode = root.right;
        TreeNode temp = root;

        if(root.left != null){
            temp = flattenWorker(root.left);
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if(rightNode != null){
            temp = flattenWorker(rightNode);
        }

        return temp;
    }
}