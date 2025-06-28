class customNode {
    int val;
    int index;
    public customNode(int valIn, int indexIn){
        val= valIn;
        index = indexIn;
    }
}

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] ans = new int[k];
        customNode[] customnodes = new customNode[nums.length];
        for(int i=0;i<nums.length;i++){
            customnodes[i] = new customNode(nums[i],i);
        }

        Arrays.sort(customnodes,Comparator.comparingInt((customNode c) -> c.val).reversed());

        customNode[] customnodesK = Arrays.copyOf(customnodes,k);

        Arrays.sort(customnodesK,Comparator.comparingInt((customNode c) -> c.index));

        for(int i=0;i<k;i++){
            ans[i] = customnodesK[i].val;
        }

        return ans;
    }
}