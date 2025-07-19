class Solution {
    Integer[][] dp;
    public int maximumLength(int[] nums, int k) {

        int n = nums.length;

        for(int i=0;i<n;i++){
            nums[i] = nums[i]%k;
        }

        int ans=0;
        dp = new Integer[nums.length][k];

        for(int i=0;i<n-1;i++){
            if(ans >= n-i){
                break;
            }
            ans = Math.max(ans,maximumLengthWorker(nums,i,-1));
        }

        return ans;
    }

    public int maximumLengthWorker(int[] nums, int index, int prev) {

        if(prev != -1 && dp[index][prev] != null){
            return dp[index][prev];
        }

        int ans=1;

        for(int i=index+1;i<nums.length;i++){
            if(nums[i] == prev || prev == -1){
                ans = Math.max(ans,1+maximumLengthWorker(nums,i,nums[index]));
                if(nums[i] == prev){
                    break;
                }
            }
        }

        if(prev != -1){
            dp[index][prev] = ans;
        }

        return ans;
    }
}


// 1,2,2,0,1,1,2,2,1,1