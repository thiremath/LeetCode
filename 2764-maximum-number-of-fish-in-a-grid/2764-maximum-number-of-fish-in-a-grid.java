class Solution {
    public int findMaxFish(int[][] grid) {
        // boolean[][] explored = new boolean[grid.length][grid[0].length];
        int res=0;

        for(int i=0;i<grid.length;i++){

            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j] > 0 ){
                    res = Math.max(res, dfs(i,j, new boolean[grid.length][grid[0].length], grid));
                    // explored[i][j] = true;
                    // res = Math.max(res, grid[i][j] + Math.max( dfs(i,j+1, explored, grid) , dfs(i+1,j, expplored, grid) ) ) ;
                }
            }
        }

        return res;
    }

    public int dfs(int i, int j, boolean[][] explored, int[][] grid){
        if(i < grid.length && i>=0 && j < grid[0].length && j>=0 && !explored[i][j] && grid[i][j] > 0){
            explored[i][j] = true;
            return grid[i][j] + dfs(i-1,j, explored, grid) + dfs(i,j-1, explored, grid) + dfs(i+1,j, explored, grid) + dfs(i,j+1, explored, grid) ;
        }

        return 0;
    }

}