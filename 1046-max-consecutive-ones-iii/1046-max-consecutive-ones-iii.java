class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCount=0,left=0,res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                zeroCount++;
            }
            if(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            res = Math.max(res,i-left+1);
        }
        return res;
    }
}