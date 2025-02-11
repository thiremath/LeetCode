class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        int ans = 1;

        for(int j=nums.length-1;j>-1;j--){

            dp[j]=1;
            
            for(int i=j+1;i<nums.length;i++){

                if(nums[j] < nums[i]){
                    dp[j] = Math.max(dp[j],1+dp[i]);
                }
            }

            ans = Math.max(ans,dp[j]);
        }

        return ans;
    }
}