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

    public int sumNumbers(TreeNode root) {
        return sumNumbersWorker(root,0);
    }
    
    public int sumNumbersWorker(TreeNode root, int sum) {

        int temp = sum*10+root.val;

        if(root.left == null && root.right == null){
            return temp;
        }

        int a=0,b=0;

        if(root.left != null){
            a = sumNumbersWorker(root.left,temp);
        }

        if(root.right != null){
            b = sumNumbersWorker(root.right,temp);
        }

        return a+b;
    }
}