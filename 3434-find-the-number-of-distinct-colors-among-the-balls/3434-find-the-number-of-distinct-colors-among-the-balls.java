class Solution {
    public int[] queryResults(int limit, int[][] queries) {

        HashMap<Integer,Integer> ballmap = new HashMap<>();
        HashMap<Integer,Integer> colmap = new HashMap<>();
        int[] res = new int[queries.length];

        for(int i=0;i<queries.length;i++){

            if(ballmap.containsKey(queries[i][0])){

                int col = ballmap.get(queries[i][0]);
                colmap.put(col,colmap.get(col)-1);
                if(colmap.get(col) == 0){

                    colmap.remove(col);
                }
            }

            ballmap.put(queries[i][0],queries[i][1]);

            if(!colmap.containsKey(queries[i][1])){
                colmap.put(queries[i][1],1);
            }

            else{
                colmap.put(queries[i][1], colmap.get(queries[i][1])+1);
            }

            res[i] = colmap.size();
        }

        return res;
    }
}