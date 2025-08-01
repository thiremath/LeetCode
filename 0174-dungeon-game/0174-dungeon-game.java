class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] prev = new int[n];

        prev[n-1] = -1;

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
            }

        }

        for(int i=m-2;i>=0;i--){
            int prevVal = prev[n-1];
            for(int j=n-1;j>=0;j--){
                int temp = Math.max(prev[j],prevVal);

                if(dungeon[i][j] < 0){
                    if(temp < 0){
                        prev[j]=temp;
                    }
                    prev[j]+=dungeon[i][j];
                    if(prev[j] == dungeon[i][j]){
                        prev[j]-=1;
                    }
                }

                else{
                    prev[j] = Math.min(-1,dungeon[i][j]+temp);
                }

                prevVal = prev[j];
            }
            
        }

        return Math.abs(prev[0]);

    }
}