class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length,n=matrix[0].length;
        int[][] res = new int[m][n];
        int res_row=0,res_col=n-1;
        
        for(int i=0;i<m;i++){
            res_row=0;
            for(int j=0;j<n;j++){
                res[res_row++][res_col] = matrix[i][j];
            }
            res_col--;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = res[i][j];
            }
        }

    }

}