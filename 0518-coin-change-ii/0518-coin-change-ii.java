class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int n = coins.length;
        int[][] dp = new int[n][5001];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return changeWorker(amount,coins,0,dp);
    }

    public int changeWorker(int amount, int[] coins, int index, int[][] dp){
        if(amount == 0){
            return 1;
        }

        if(amount < 0 || index >= coins.length){
            return 0;
        }

        if(dp[index][amount] != -1){
            return dp[index][amount];
        }

        return dp[index][amount] = changeWorker(amount-coins[index],coins,index,dp)+changeWorker(amount,coins,index+1,dp);

    }
}