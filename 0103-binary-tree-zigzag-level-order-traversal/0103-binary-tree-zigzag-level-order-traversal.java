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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        queue.add(root);

        boolean isLeftToRightTrav = true;

        while(!queue.isEmpty()){

            int Size = queue.size();
            List<Integer> currLevelNodes = new ArrayList<>();

            while(Size-- != 0){
                TreeNode currNode = queue.poll();
                currLevelNodes.add(currNode.val);
                
                if(currNode.left != null){
                    queue.add(currNode.left);
                }

                if(currNode.right != null){
                    queue.add(currNode.right);
                }
            }

            if(!isLeftToRightTrav){
                currLevelNodes = reverseList(currLevelNodes);
            }

            res.add(currLevelNodes);
            isLeftToRightTrav = !isLeftToRightTrav;
        }

        return res;
    }

    public List<Integer> reverseList(List<Integer> listIn){
        List<Integer> reversedList = new ArrayList<>();

        for(int i=listIn.size()-1;i>=0;i--){
            reversedList.add(listIn.get(i));
        }

        return reversedList;
    }
}