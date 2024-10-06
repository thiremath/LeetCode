class Solution {
    int ans;
    public int maximalSquare(char[][] matrix) {
        ans=0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }
        maximalSquareWorker(matrix,0,0,dp);
        return ans*ans;
    }

    public void maximalSquareWorker(char[][] matrix, int i, int j, int[][] dp) {

        if(i < matrix.length && j < matrix[0].length){

            if(dp[i][j] == -1){

                maximalSquareWorker(matrix,i+1,j,dp);
                maximalSquareWorker(matrix,i,j+1,dp);
                maximalSquareWorker(matrix,i+1,j+1,dp);

                dp[i][j] = 0;
                if(matrix[i][j] == '1'){
                    dp[i][j] = 1;
                    if(i+1 < matrix.length && j+1 < matrix[0].length){
                        if(dp[i+1][j] > 0 && dp[i][j+1] > 0 && dp[i+1][j+1] > 0){
                            dp[i][j] = 1 + Math.min(dp[i+1][j],Math.min(dp[i][j+1],dp[i+1][j+1]));
                        }
                    }
                }

                ans = Math.max(ans,dp[i][j]);

            }

        }

    }
}