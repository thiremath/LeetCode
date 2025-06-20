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
    int curr=1;
    public int kthSmallest(TreeNode root, int k) {

        if(root.left == null && k == curr){
            return root.val;
        }

        int ans=-1;

        if(root.left != null){
            ans = kthSmallest(root.left,k);
            if(ans != -1){
                return ans;
            }
            curr++;
        }

        if(k == curr){
            return root.val;
        }

        if(root.right != null){
            ans = kthSmallest(root.right,k-1);
            if(ans != -1){
                return ans;
            }
            curr++;
        }

        return -1;
    }

}