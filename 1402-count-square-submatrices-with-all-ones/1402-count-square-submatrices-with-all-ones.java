class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length,n=matrix[0].length;
        int res=0;

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int count = Integer.MAX_VALUE;
                if(matrix[i][j] == 1 && i < m-1 && j < n-1){
                    count = Math.min(matrix[i+1][j],matrix[i][j+1]);
                    count = Math.min(count,matrix[i+1][j+1]);
                }
                if(count != Integer.MAX_VALUE){
                    matrix[i][j]+=count;
                }
                res+=matrix[i][j];
            }
        }

        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(matrix[i][j]+" ");
        //     }
        //     System.out.println("");
        // }

        return res;
    }
}