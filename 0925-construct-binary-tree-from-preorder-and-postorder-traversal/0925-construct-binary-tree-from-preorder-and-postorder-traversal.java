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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        for (int i = 0; i < postorder.length / 2; i++) {
            int t = postorder[i];
            postorder[i] = postorder[postorder.length - 1 - i];
            postorder[postorder.length - 1 - i] = t;
        }

        return constructFromPrePostWorker(preorder,postorder,0,preorder.length-1,0,preorder.length-1);
    }

    public TreeNode constructFromPrePostWorker(int[] preorder, int[] postorder,int prelow, int prehigh, int postlow, int posthigh){
        
        //base case
        if(prelow > prehigh || postlow > posthigh){
            return null;
        }

        // diff element
        if(preorder[prelow] != postorder[postlow]){
            return new TreeNode(preorder[prelow]);
        }

        // same element
        TreeNode head = new TreeNode(preorder[prelow]);
        TreeNode curr = head;

        while(prelow+1 <= prehigh && postlow+1 <= posthigh && preorder[prelow+1] == postorder[postlow+1]){
            curr.right = new TreeNode(preorder[prelow+1]);
            curr = curr.right;
            prelow++;
            postlow++;
        }

        if(prelow <= prehigh && postlow <= posthigh){

            int temp1 = prelow;
            int temp2 = postlow;

            HashSet<Integer> set = new HashSet<>();

            while(++prelow <= prehigh && ++postlow <= posthigh){
                if(!set.contains(preorder[prelow]) && !set.contains(postorder[postlow])){
                    set.add(preorder[prelow]);
                    set.add(postorder[postlow]);
                }
                else{
                    if(set.contains(preorder[prelow])){
                        while(!set.contains(postorder[postlow]) && ++postlow <= posthigh){}
                    }
                    if(set.contains(postorder[postlow])){
                        while(!set.contains(preorder[prelow]) && ++prelow <= prehigh){}
                    }
                    break;
                }
            }

            curr.left = constructFromPrePostWorker(preorder,postorder,1+temp1,prelow-1,postlow,posthigh);
            curr.right = constructFromPrePostWorker(preorder,postorder,prelow,prehigh,1+temp2,postlow-1);
        }

        return head;
    }

}

/**

1,2,4,5,3,6,7

1,3,7,6,2,5,4


1|2,4,5|3,6,7

1|3,7,6|2,5,4


1,2,4,5,3,6,7

1,2,5,4,3,7,6


2,1,3

2,1,3



 */