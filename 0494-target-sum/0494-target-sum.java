class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int ans = findTargetSumWaysWorker(nums,target,0,dp,0);
        return (ans == -1) ? 0 : ans;
    }

    public int findTargetSumWaysWorker(int[] nums ,int target, int index, int[] dp,int currSum){

        // System.out.println(currSum);

        if(currSum == target && index == nums.length){
            return 1;
        }

        if(index >= nums.length){
            return -1;
        }

        // if(dp[index] == -1){
            // System.out.println("-1");
            int ans = 0;
            int a = findTargetSumWaysWorker(nums,target,index+1,dp,currSum-nums[index]);
            // System.out.println("+1");
            int b = findTargetSumWaysWorker(nums,target,index+1,dp,currSum+nums[index]);
            if(a != -1 && b != -1){
                ans = a+b;
            }
            else if(a == -1){
                ans = b;
            }
            else{
                ans = a;
            }
        // }

        return ans;
    }
}