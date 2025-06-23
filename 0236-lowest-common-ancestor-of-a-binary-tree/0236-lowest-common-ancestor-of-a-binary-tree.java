/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        Boolean leftNode =  find(root.left,p.val,q.val);
        Boolean rightNode = find(root.right,p.val,q.val);

        // System.out.println(root.val+" "+leftNode+" "+rightNode);

        if( (leftNode && rightNode) || ( (root.val == p.val || root.val == q.val) && (leftNode || rightNode)) ){
            return root;
        }

        if(leftNode){
            return lowestCommonAncestor(root.left,p,q);
        }

        return lowestCommonAncestor(root.right,p,q);

    }

    public Boolean find(TreeNode root, int p, int q){

        if(root == null){
            return false;
        }

        if(root.val == p || root.val == q){
            return true;
        }

        return find(root.left,p,q) || find(root.right,p,q);
    }
}