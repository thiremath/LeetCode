class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        // int[][] indegree = new int[matrix.length][matrix[0].length];
        // int[][] outdegree = new int[matrix.length][matrix[0].length];

        // for(int i=0;i<matrix.length;i++){
        //     Arrays.fill(indegree[i],-1);
        //     Arrays.fill(outdegree[i],-1);
        // }

        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[i].length;j++){
        //         if(i-1 > 0){
        //             if(matrix[i-1][j] > matrix[i][j]){
        //                 if()
        //                 outdegree[i][j]
        //             }
        //         }
        //     }
        // }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] decreasingLen = new int[m][n];
        // int[][] visited = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(decreasingLen[i],-1);
            // Arrays.fill(visited[i],-1);
            // Arrays.fill(increasingLen[i],-1);
        }

        int ans = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans = Math.max(ans,longestIncreasingPathWorker(matrix,i,j,decreasingLen,m,n));
            }
        }

        return ans;

    }

    public int longestIncreasingPathWorker(int[][] matrix, int i, int j, int[][] decreasingLen, int m, int n){
        
        if(i >= m || j >= n || i < 0 || j < 0){
            return 0;
        }

        if(decreasingLen[i][j] != -1){
            return decreasingLen[i][j];
        }

        int ans = 1;
        int currNumber = matrix[i][j];

        if(j-1 >= 0){
            if(currNumber < matrix[i][j-1]){
                ans = Math.max(ans,1+longestIncreasingPathWorker(matrix,i,j-1,decreasingLen,m,n));
            }
        }

        if(i+1 < m){
            if(currNumber < matrix[i+1][j]){
                ans = Math.max(ans,1+longestIncreasingPathWorker(matrix,i+1,j,decreasingLen,m,n));
            }
        }

        if(j+1 < n){
            if(currNumber < matrix[i][j+1]){
                ans = Math.max(ans,1+longestIncreasingPathWorker(matrix,i,j+1,decreasingLen,m,n));
            }
        }

        if(i-1 >= 0){
            if(currNumber < matrix[i-1][j]){
                ans = Math.max(ans,1+longestIncreasingPathWorker(matrix,i-1,j,decreasingLen,m,n));
            }
        }

        return decreasingLen[i][j] = ans;

    }
}