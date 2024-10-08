class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }
        return uniquePathsWithObstacles(obstacleGrid,obstacleGrid.length-1,obstacleGrid[0].length-1,dp);
    }

    public int uniquePathsWithObstacles(int[][] grid, int i, int j, int[][] dp) {
        if(i==0 && j==0 && grid[i][j]==0){
            return 1;
        }
        if(i >= 0 && j >= 0 && grid[i][j] == 0){
            if(dp[i][j] == -1){
                dp[i][j] = uniquePathsWithObstacles(grid,i,j-1,dp) + uniquePathsWithObstacles(grid,i-1,j,dp) ;
            }
            // System.out.println(i+" "+j+" "+dp[i][j]);
            return dp[i][j];
        }
        return 0;
    }
    
}