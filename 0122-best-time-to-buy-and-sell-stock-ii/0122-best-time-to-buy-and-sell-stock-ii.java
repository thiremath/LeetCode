class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        int temp = prices[n-1];

        for(int i=n-2;i>=0;i--){ 
            if(prices[i] >= temp){
                // dp[i] = dp[i+1];
                temp = prices[i];
            }
            else{
                dp[i]+=(temp-prices[i]);
                temp = prices[i];
            }
            dp[i]+=dp[i+1];
        }

        return dp[0];
    }
}