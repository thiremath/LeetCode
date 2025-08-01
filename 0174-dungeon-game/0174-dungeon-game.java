class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] prev = new int[n];
        int[] curr = new int[n];

        prev[n-1] = 1;

        if(dungeon[m-1][n-1] < 0){
            prev[n-1] = dungeon[m-1][n-1]-1;
        }

        for(int i=n-2;i>=0;i--){

            if(dungeon[m-1][i] < 0){
                if(prev[i+1] < 0){
                    prev[i]=prev[i+1];
                }
                prev[i]+=dungeon[m-1][i];
                if(prev[i] == dungeon[m-1][i]){
                    prev[i]-=1;
                }
            }

            else{
                prev[i] = Math.min(-1,dungeon[m-1][i]+prev[i+1]);
                // if(prev[i]==0){
                //     prev[i]=-1;
                // }
            }

        }

        // for(int i=0;i<n;i++){
        //     System.out.print(prev[i]+" ");
        // }

        // System.out.println("");

        for(int i=m-2;i>=0;i--){
            int prevVal = prev[n-1];
            for(int j=n-1;j>=0;j--){
                // System.out.println("");
                // System.out.println("prevVal = "+prevVal);
                int temp = Math.max(prev[j],prevVal);

                // System.out.println("dungeon[i][j] = "+dungeon[i][j]);

                if(dungeon[i][j] < 0){
                    if(temp < 0){
                        curr[j]=temp;
                    }
                    curr[j]+=dungeon[i][j];
                    if(curr[j] == dungeon[i][j]){
                        curr[j]-=1;
                    }
                }

                else{
                    // System.out.println("dungeon[i][j]+temp = "+dungeon[i][j]+temp);
                    curr[j] = Math.min(-1,dungeon[i][j]+temp);
                    // if(curr[j]==0){
                    //     curr[j]=-1;
                    // }
                }


                // System.out.println("currj = "+curr[j]);
                prevVal = curr[j];
            }

            // for(int k=0;k<n;k++){
            //     System.out.print(prev[k]+" ");
            // }

            // System.out.println("");
            
            prev = curr;
        }

        return Math.abs(prev[0]);

    }
}