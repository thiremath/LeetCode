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
    int index;
    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode ans = new TreeNode();
        TreeNode head = ans;
        index=0;

        recoverFromPreorderWorker(traversal.toCharArray(),ans,0,0);
        return head;
    }

    public int recoverFromPreorderWorker(char[] arr, TreeNode root, int dashes, int depth) {

        if(dashes == -1){
            return -1;
        }

        if(dashes == depth){
            // System.out.println(arr[index]);
            int value = Integer.parseInt(String.valueOf(arr[index]));
            while(++index < arr.length && arr[index]!= '-'){
                value = value*10 + Integer.parseInt(String.valueOf(arr[index]));
            }
            root.val = value;
        }

        dashes=0;
        while(index < arr.length && arr[index] == '-'){dashes++;index++;}

        if(dashes == 0){
            return -1;
        }

        if(dashes == depth+1){
            root.left = new TreeNode();
            dashes = recoverFromPreorderWorker(arr,root.left,dashes,depth+1);
            if(dashes == depth+1){
                root.right = new TreeNode();
                return recoverFromPreorderWorker(arr,root.right,dashes,depth+1);
            }
        }

        return dashes;

    }
    
}