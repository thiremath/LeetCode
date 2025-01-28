class Solution {
    public int findMaxFish(int[][] grid) {
        int res=0;

        for(int i=0;i<grid.length;i++){

            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j] > 0){
                    res = Math.max(res, dfs(i,j, grid));
                }
            }
        }

        return res;
    }

    public int dfs(int i, int j, int[][] grid){
        if(i < grid.length && i>=0 && j < grid[0].length && j>=0 && grid[i][j] > 0){
            int temp = grid[i][j];
            grid[i][j] = 0;
            return temp + dfs(i-1,j, grid) + dfs(i,j-1, grid) + dfs(i+1,j, grid) + dfs(i,j+1, grid) ;
        }

        return 0;
    }

}