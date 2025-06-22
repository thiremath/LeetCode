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
    HashMap<Integer,Integer> premap;
    HashMap<Integer,Integer> inmap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        premap = new HashMap<>();
        inmap = new HashMap<>();
        for(int i=0;i<preorder.length;i++){
            premap.put(preorder[i],i);
            inmap.put(inorder[i],i);
        }
        return buildTreeWorker(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode buildTreeWorker(int[] preorder, int[] inorder, int prelow, int prehigh, int inlow, int inhigh){

        if(prelow < 0 || inhigh < 0 || prehigh >= preorder.length || inhigh >= inorder.length || prelow > prehigh || inlow > inhigh){
            return null;
        }

        if(prelow == prehigh){
            return new TreeNode(preorder[prelow]);
        }

        int inorderIndex = inmap.get(preorder[prelow]);
        int left = inorderIndex-inlow;
        int right = inhigh-inorderIndex;

        TreeNode curr = new TreeNode(preorder[prelow]);

        curr.left = buildTreeWorker(preorder,inorder,prelow+1,prelow+left,inlow,inorderIndex-1);
        curr.right = buildTreeWorker(preorder,inorder,prelow+left+1,prehigh,inorderIndex+1,inhigh);

        return curr;
    }
}