class Solution {
    public int maxProfit(int k, int[] prices) {
        Integer[][][] dp = new Integer[prices.length][2][k+1];
        return maxProfitWorker(k,prices,0,1,dp);
    }

    public int maxProfitWorker(int k, int[] prices, int idx, int buy, Integer[][][] dp) {

        if(idx >= prices.length || k == 0){
            return 0;
        }

        if(dp[idx][buy][k] != null){
            return dp[idx][buy][k];
        }

        int ans = 0;

        if(buy == 1){
            ans = -prices[idx]+maxProfitWorker(k,prices,idx+1,0,dp);
        }

        else{
            ans = prices[idx]+maxProfitWorker(k-1,prices,idx+1,1,dp);
        }

        return dp[idx][buy][k] = Math.max(ans,maxProfitWorker(k,prices,idx+1,buy,dp));
    }
}