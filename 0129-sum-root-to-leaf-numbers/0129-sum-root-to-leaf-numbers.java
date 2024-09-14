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
    int ans=0,currans=0;
    public int sumNumbers(TreeNode root) {
        sumNumbersWorker(root);
        return ans;
    }

    public void sumNumbersWorker(TreeNode root){

        currans = currans * 10 + root.val ;

        if(root.left == null && root.right == null){
            ans += currans;
        }

        if(root.left != null){
            sumNumbersWorker(root.left);
        }

        if(root.right != null){
            sumNumbersWorker(root.right);
        }

        currans = (currans - root.val) / 10 ;

    }
}