class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int ans=0,m=grid.length,n=grid[0].length;
        int[][] dirs = {
            {-1,-1},{1,1},{0,-1},{0,1},{-1,0},{1,0},{1,-1},{-1,1}
        };

        if(grid[0][0] == 0){
            queue.offer(new int[]{0,0});
        }

        while(!queue.isEmpty()){
            int Size = queue.size();
            while(Size-- > 0){
                int[] currIndex = queue.poll();
                if(currIndex[0]==m-1 && currIndex[1]==n-1){
                    return ans+1;
                }
                for(int[] dir: dirs){
                    int[] nextIndex = {currIndex[0]+dir[0], currIndex[1]+dir[1]};
                    if(nextIndex[0] >= 0 && nextIndex[0] < m && nextIndex[1] >= 0 && nextIndex[1] < n && grid[nextIndex[0]][nextIndex[1]]==0){
                        queue.add(nextIndex);
                        grid[nextIndex[0]][nextIndex[1]] = -1;
                    }
                }
            }
            ans++;
        }

        return -1;
    }
}