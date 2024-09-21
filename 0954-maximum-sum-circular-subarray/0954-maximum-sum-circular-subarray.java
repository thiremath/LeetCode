class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int ans = nums[0];
        int minans = nums[0];
        int currsum = 0;
        int currminsum = 0;
        int total = 0;

        for(int curr=0;curr<nums.length;curr++){

            if(nums[curr]+currsum < nums[curr]){
                currsum = nums[curr];
            }
            else{
                currsum+=nums[curr];
            }

            if(nums[curr]+currminsum > nums[curr]){
                currminsum = nums[curr];
            }

            else{
                currminsum+=nums[curr];
            }

            ans = Math.max(ans,currsum);
            minans = Math.min(minans,currminsum);

            total+=nums[curr];
        }

        if(minans != total){
            return Math.max(ans,total-minans);
        }

        return ans;

    }
}