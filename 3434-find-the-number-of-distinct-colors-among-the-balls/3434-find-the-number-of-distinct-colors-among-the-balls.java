class Solution {
    public int[] queryResults(int limit, int[][] queries) {

        HashMap<Integer,Integer> ballmap = new HashMap<>();
        HashMap<Integer,Integer> colmap = new HashMap<>();
        int[] res = new int[queries.length];

        for(int i=0;i<queries.length;i++){

            int ball = queries[i][0];
            int col = queries[i][1];

            if(ballmap.containsKey(ball)){

                int currcol = ballmap.get(ball);
                colmap.put(currcol,colmap.get(currcol)-1);
                if(colmap.get(currcol) == 0){

                    colmap.remove(currcol);
                }
            }

            ballmap.put(ball,col);

            if(!colmap.containsKey(col)){
                colmap.put(col,1);
            }

            else{
                colmap.put(col, colmap.get(col)+1);
            }

            res[i] = colmap.size();
        }

        return res;
    }
}