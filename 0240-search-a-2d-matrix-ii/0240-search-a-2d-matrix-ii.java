class Solution {
    boolean[][] visited;
    public boolean searchMatrix(int[][] matrix, int target) {
        visited = new boolean[matrix.length][matrix[0].length];
        return searchMatrixWorker(matrix,target,0,0);
    }
    
    public boolean searchMatrixWorker(int[][] matrix, int target,int i,int j) {
        boolean ans=false;

        if(i>=0 && j>=0 && i<matrix.length && j<matrix[0].length){

            visited[i][j] = true;

            if(matrix[i][j] == target){
                ans= true;
            }
            else if(matrix[i][j] < target){
                if(i+1 < matrix.length && !visited[i+1][j]){
                    ans = searchMatrixWorker(matrix,target,i+1,j);
                }
                if(j+1 < matrix[0].length && !visited[i][j+1]){
                
                    ans =  ans || searchMatrixWorker(matrix,target,i,j+1);
                }
            }
            else{
                if(i-1 >= 0 && !visited[i-1][j]){
                    ans = searchMatrixWorker(matrix,target,i-1,j);
                }
                if(j-1 >= 0 && !visited[i][j-1]){
                    ans =  ans || searchMatrixWorker(matrix,target,i,j-1);
                }
            }
        }

        return ans;
    }
}