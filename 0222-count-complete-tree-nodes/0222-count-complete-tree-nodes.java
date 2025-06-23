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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftheight = 1, rightheight = 1;

        TreeNode temp = root;

        while(temp.left != null){
            leftheight++;
            temp = temp.left;
        }

        temp = root;

        while(temp.right != null){
            rightheight++;
            temp = temp.right;
        }

        // System.out.println(root.val+" "+leftheight+" "+rightheight);

        if(leftheight == rightheight){
            // System.out.println("shift = "+((1 << (leftheight))-1));
            return (1 << (leftheight))-1;
        }

        return 1+countNodes(root.left)+countNodes(root.right);
    }

    // public int height(TreeNode node){
    //     if(node == null){
    //         return 0;
    //     }

    //     return 1+height(node.left);
    // }
}