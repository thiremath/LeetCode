class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    ans++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] visited){
        visited[i][j]=true;
        if(i >= 1 && !visited[i-1][j] && grid[i-1][j]=='1'){
            dfs(i-1,j,grid,visited);
        }
        if(j >= 1 && !visited[i][j-1]&& grid[i][j-1]=='1'){
            dfs(i,j-1,grid,visited);
        }
        if(i < grid.length-1 && !visited[i+1][j]&& grid[i+1][j]=='1'){
            dfs(i+1,j,grid,visited);
        }
        if(j < grid[0].length-1 && !visited[i][j+1]&& grid[i][j+1]=='1'){
            dfs(i,j+1,grid,visited);
        }
    }
}