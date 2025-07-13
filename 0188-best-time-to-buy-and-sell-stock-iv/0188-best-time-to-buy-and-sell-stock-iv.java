class Solution {
    public int maxProfit(int x, int[] prices) {
        int n = prices.length;
        int[][] next = new int[2][x+1];
        int[][] curr = new int[2][x+1];

        for(int i=n-1;i>=0;i--){
            for(int j=1;j>=0;j--){
                for(int k=x;k>0;k--){

                    int ans=0;

                    if(j == 1){
                        ans = prices[i]+next[0][k-1];
                    }
                    else{
                        ans = -prices[i]+next[1][k];
                    }   

                    curr[j][k] = Math.max(ans,next[j][k]);
                }
            }
            next = curr;
        }

        return next[0][x];
    }
}