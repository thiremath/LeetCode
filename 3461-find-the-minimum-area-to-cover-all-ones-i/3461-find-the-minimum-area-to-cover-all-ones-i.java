class Solution {
    public int minimumArea(int[][] grid) {
        int x1=Integer.MAX_VALUE,x2=Integer.MIN_VALUE,y1=Integer.MAX_VALUE,y2=Integer.MIN_VALUE;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    x1 = Math.min(i,x1);
                    x2 = Math.max(i,x2);
                    y1 = Math.min(j,y1);
                    y2 = Math.max(j,y2);
                }
            }
        }

        return (x2-x1+1)*(y2-y1+1);
    }
}