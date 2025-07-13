class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int x = 2;
        int[][][] dp = new int[n+1][2][x+1];

        // fill k=0 with 0
        for(int[][] twod:dp){
            for(int[] oned: twod){
                oned[0] = 0;
            }
        }

        // fill index = n with 0
        for(int i=0;i<2;i++){
            for(int j=0;j<=x;j++){
                dp[n][i][j] = 0;
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int j=1;j>=0;j--){
                for(int k=x;k>0;k--){

                    int ans=0;

                    if(j == 1){
                        ans = prices[i]+dp[i+1][0][k-1];
                    }
                    else{
                        ans = -prices[i]+dp[i+1][1][k];
                    }   

                    dp[i][j][k] = Math.max(ans,dp[i+1][j][k]);
                }
            }
        }

        return dp[0][0][x];
    }
}