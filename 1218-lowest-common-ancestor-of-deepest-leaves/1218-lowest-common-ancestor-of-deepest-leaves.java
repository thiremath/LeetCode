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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return lcaWorker(root,0).lcs;
    }

    public Pair lcaWorker(TreeNode root, int depth){

        if(root == null){
            return null;
        }

        // System.out.println(root.val+" "+depth);

        Pair left = lcaWorker(root.left,depth+1);
        Pair right = lcaWorker(root.right,depth+1);

        if(left == null && right == null){
            return new Pair(depth,root);
        }

        if(left == null){
            return right;
        }

        if(right == null){
            return left;
        }

        if(left.depth > right.depth){
            return left;
        }

        if(left.depth < right.depth){
            return right;
        }

        return new Pair(left.depth,root);
    }
}

class Pair{
    int depth;
    TreeNode lcs;

    public Pair(int depthIn, TreeNode lcsIn){
        depth = depthIn;
        lcs = lcsIn;
    }
}