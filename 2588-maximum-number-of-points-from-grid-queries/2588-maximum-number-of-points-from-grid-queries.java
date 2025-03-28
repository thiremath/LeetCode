class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {

        int m = grid.length;
        int n = grid[0].length;

        int[] res = new int[queries.length];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> p_queue = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        visited[0][0] = true;
        p_queue.add(new int[] {grid[0][0],0,0});

        int[][] sortedQueries = new int[queries.length][2];

        for(int i=0;i<sortedQueries.length;i++){
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries,(x,y) -> Integer.compare(x[0],y[0]));
        
        for(int i=0;i<sortedQueries.length;i++){

            int currRes=0;

            while(p_queue.size() > 0){

                if(p_queue.peek()[0] < sortedQueries[i][0]){

                    int row = p_queue.peek()[1];
                    int column = p_queue.peek()[2];

                    // int temp = p_queue.remove()[0];
                    p_queue.remove();
                    currRes++;

                    // if(sortedQueries[i][0] == 5){
                    //     System.out.println("currRes = "+currRes+" qremove = "+temp);
                    // }

                    if(row-1 >= 0){
                        if(!visited[row-1][column]){
                            visited[row-1][column] = true;
                            p_queue.offer(new int[]{grid[row-1][column],row-1,column});
                        }
                    }

                    if(column-1 >= 0){
                        if(!visited[row][column-1]){
                            visited[row][column-1] = true;
                            p_queue.offer(new int[]{grid[row][column-1],row,column-1});
                        }
                    }

                    if(row+1 < m){
                        if(!visited[row+1][column]){
                        visited[row+1][column] = true;
                            p_queue.offer(new int[]{grid[row+1][column],row+1,column});
                        }
                    }

                    if(column+1 < n){
                        if(!visited[row][column+1]){
                            visited[row][column+1] = true;
                            p_queue.offer(new int[]{grid[row][column+1],row,column+1});
                        }
                    }

                }

                else{
                    break;
                }

            }

            if(i != 0){
                currRes += res[sortedQueries[i-1][1]];
            }

            res[sortedQueries[i][1]] = currRes;

        }

        return res;
    }

}