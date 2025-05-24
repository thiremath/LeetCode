class Solution {
    // boolean visited[][];
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        // visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board,i,j,word,0, new boolean[m][n])){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean backtrack(char[][] board, int m, int n, String word, int index, boolean[][] visited){

        if(index == word.length()){
            return true;
        }

        if(m < 0 || n < 0 || m >= board.length || n >= board[0].length || (visited[m][n] == true) || board[m][n] != word.charAt(index)){
            return false;
        }

        visited[m][n] = true;

        boolean ret = backtrack(board,m-1,n,word,index+1,visited) || backtrack(board,m,n-1,word,index+1,visited) || backtrack(board,m+1,n,word,index+1,visited) || backtrack(board,m,n+1,word,index+1,visited);

        if(!ret){
            visited[m][n] = false;
        }

        return ret;

        
    }
}