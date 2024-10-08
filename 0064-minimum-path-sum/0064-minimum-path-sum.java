class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }
        return minPathSumWorker(grid,grid.length-1,grid[0].length-1,dp);
    }

    public int minPathSumWorker(int[][] grid, int i, int j, int[][] dp) {
        if(i==0 && j==0){
            return grid[i][j];
        }
        if(i >= 0 && j >= 0){
            if(dp[i][j] == -1){
                dp[i][j] = grid[i][j] + Math.min(minPathSumWorker(grid,i,j-1,dp),minPathSumWorker(grid,i-1,j,dp));

            }
            // System.out.println(i+" "+j+" "+dp[i][j]);
            return dp[i][j];
        }
        return Integer.MAX_VALUE;
    }
    
}