class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        int ans = 1;

        for(int j=nums.length-1;j>-1;j--){

            int currres = 1;
            for(int i=j+1;i<nums.length;i++){

                if(nums[j] < nums[i]){
                    currres = Math.max(currres,1+dp[i]);
                }
            }
            dp[j] = currres;
            ans = Math.max(ans,currres);
        }

        return ans;
    }
}