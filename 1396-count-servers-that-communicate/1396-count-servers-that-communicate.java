class Solution {
    public int countServers(int[][] grid) {
        boolean[] isColComm = new boolean[grid[0].length];
        int res=0;

        for(int i=0;i<grid[0].length;i++){

            boolean flag = false;

            for(int j=0;j<grid.length;j++){

                if(grid[j][i] == 1){
                    if(flag){
                        isColComm[i] = true;
                        break;
                    }
                    flag=true;
                }

            }
        }


        for(int i=0;i<grid.length;i++){

            // boolean flag = false;
            int temp = -1;
            int tempres = 0;

            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j] == 1){
                    // flag=true;   
                    temp = j;
                    tempres++;
                }

            }

            if(tempres > 1 || (tempres==1 && isColComm[temp] == true)){
                res+=tempres; 
            }

        }

        return res;

    }
}