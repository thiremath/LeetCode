class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int ans = Math.abs(nums[n-1]-nums[0]);

        for(int i=0;i<n-1;i++){
            ans = Math.max(ans,Math.abs(nums[i]-nums[i+1]));
        }

        return ans;
    }
}