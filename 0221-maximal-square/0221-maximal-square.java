class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }
        maximalSquareWorker(matrix,0,0,dp);
        int ans=0;
        for(int[] i: dp){
            for(int j: i){
                ans = Math.max(ans,j);
            }
        }
        return ans*ans ;
    }

    public void maximalSquareWorker(char[][] matrix, int i, int j, int[][] dp) {
        if(i < matrix.length && j < matrix[0].length){
            if(dp[i][j] == -1){

                maximalSquareWorker(matrix,i+1,j,dp);
                maximalSquareWorker(matrix,i,j+1,dp);
                maximalSquareWorker(matrix,i+1,j+1,dp);

                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }

                else{
                    dp[i][j] = 1;
                    if(i+1 < matrix.length && j+1 < matrix[0].length){
                        if(dp[i+1][j] > 0 && dp[i][j+1] > 0 && dp[i+1][j+1] > 0){
                            dp[i][j] = 1 + Math.min(dp[i+1][j],Math.min(dp[i][j+1],dp[i+1][j+1]));
                        }
                    }
                }
                
            }
        }

    }
}