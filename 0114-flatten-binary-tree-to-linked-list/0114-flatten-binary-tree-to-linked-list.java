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
        TreeNode temp = null;
        TreeNode temp2 = null;

        if(root.left == null && root.right == null){
            return root;
        }

        if(root.right != null){
            temp = flattenWorker(root.right);
        }

        if(root.left != null){
            temp2 = flattenWorker(root.left);
            if(root.right == null){
                temp = temp2;
            }
            flattenWorker(root.left).right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return temp;


        // root.right = lnode;
        // root.left = null;
    }

}