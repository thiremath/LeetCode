class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int ans = -1;
        for(int i: nums){
            if(i > min) ans = Math.max(ans,i-min);
            else min = i;
        }
        return ans;
    }
}