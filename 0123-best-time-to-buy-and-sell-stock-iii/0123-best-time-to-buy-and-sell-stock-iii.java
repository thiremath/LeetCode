class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return maxProfitWorker(prices,0,1,2,dp);
    }

    public int maxProfitWorker(int[] prices, int index, int buy, int k, int[][][] dp) {
        if(index >= prices.length || k < 0){
            return 0;
        }

        if(dp[index][buy][k] != -1){
            return dp[index][buy][k];
        }

        int ans=0;

        if(buy==1){
            ans = -prices[index]+maxProfitWorker(prices,index+1,0,k-1,dp);
        }

        else{
            ans = prices[index]+maxProfitWorker(prices,index+1,1,k,dp);
        }

        return dp[index][buy][k] = Math.max(ans,maxProfitWorker(prices,index+1,buy,k,dp));
    }   
}