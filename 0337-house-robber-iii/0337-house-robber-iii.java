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
    Map<TreeNode,int[]> map;
    public int rob(TreeNode root) {
        map = new HashMap<>();
        return robWorker(root,true);
    }

    public int robWorker(TreeNode root, boolean canRob) {

        if(root == null) return 0;

        int[] ret = new int[0];

        if(map.containsKey(root)){
            ret = map.get(root);
            if(canRob && ret[0] != -1){
                return ret[0];
            }
            else if(!canRob && ret[1] != -1){
                return ret[1];
            }
        }

        if(ret.length == 0){
            ret = new int[]{-1,-1};
        }

        int rob=0;

        if(canRob){
            rob = root.val+robWorker(root.left,false)+robWorker(root.right,false);
        }

        int notrob = robWorker(root.left,true)+robWorker(root.right,true);

        if(canRob){
            ret[0] = Math.max(rob,notrob);
        }

        ret[1] = notrob;

        map.put(root,ret);

        return (canRob) ? ret[0] : ret[1];
    }
}