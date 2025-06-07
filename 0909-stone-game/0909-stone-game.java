class Solution {
    public boolean stoneGame(int[] piles) {
        int sum=0;
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            sum+=piles[i];
            Arrays.fill(dp[i],-1);
        }
        return (stoneGameWorker(piles,0,n-1,true,dp) > sum/2);
    }

    public int stoneGameWorker(int[] piles, int low, int high, boolean isAliceTurn,int[][] dp) {
        if(low == high){
            return piles[low];
        }

        if(dp[low][high] != -1){
            return dp[low][high];
        }

        if(isAliceTurn){
            return dp[low][high] = Math.max(piles[low]+stoneGameWorker(piles,low+1,high,false,dp), piles[high]+stoneGameWorker(piles,low,high-1,false,dp));
        }

        return dp[low][high] = Math.min(piles[low]+stoneGameWorker(piles,low+1,high,true,dp), piles[high]+stoneGameWorker(piles,low,high-1,true,dp));
    }
}