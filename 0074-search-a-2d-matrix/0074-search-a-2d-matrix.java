class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrixWorker(matrix,target,0,matrix.length*matrix[0].length-1);
    }

    public boolean searchMatrixWorker(int[][] matrix, int target, int low, int high) {

        if(high >= low){

            int mid = (high+low) / 2 ;

            if(matrix[mid/matrix[0].length][mid%matrix[0].length] == target){
                return true;
            }

            else if(matrix[mid/matrix[0].length][mid%matrix[0].length] > target){
                return searchMatrixWorker(matrix,target,low,mid-1);
            }

            else{
                return searchMatrixWorker(matrix,target,mid+1,high);        
            }

        }

        return false;
    }
}