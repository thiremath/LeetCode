class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int ans=nums[0],minans = nums[0];
        int currsum=0,currminsum=0,total = 0;

        for(int curr=0;curr<nums.length;curr++){
            currsum = Math.max(nums[curr]+currsum,nums[curr]);
            currminsum = Math.min(nums[curr]+currminsum,nums[curr]);
            ans = Math.max(ans,currsum);
            minans = Math.min(minans,currminsum);
            total+=nums[curr];
        }

        return (minans != total)? Math.max(ans,total-minans) : ans;

    }
}