class Solution {
    public int change(int amount, int[] coins) {
        // if(coins[index] > amount) dp[amount][index]=0;

        // dp[amount][index] = dp[amount-coins[index]][index]+ dp[amount][index+1];

        // dp[amount][0];

        int[][] dp = new int[amount+1][coins.length];

        // when amount =0 0 way

        for(int i=0;i<coins.length;i++){
            dp[0][i] = 1;
        }

        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                dp[coins[i]][i]=1;
            }
        }

        int ans=0;

        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j] > i && j>0) dp[i][j]=dp[i][j-1];
                else{
                    // if(i==amount){
                    //     ans+=dp[i][j];
                    // }
                    if(i-coins[j]>0){
                        dp[i][j] += dp[i-coins[j]][j];
                    }
                    if(j>0){
                        dp[i][j]+= dp[i][j-1];
                    }
                }
            }
        }

        // for(int i=0;i<=amount;i++){
        //     for(int j=0;j<coins.length;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println("");
        // }

        // System.out.println("ans= "+ans);

        return dp[amount][coins.length-1];

    }
}

