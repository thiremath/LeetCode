class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int currsum = 0;

        for(int curr=0;curr<nums.length;curr++){
            if(nums[curr]+currsum < nums[curr]){
                currsum = nums[curr];
            }
            else{
                currsum+=nums[curr];
            }
            ans = Math.max(ans,currsum);
        }

        return ans;
    }
}