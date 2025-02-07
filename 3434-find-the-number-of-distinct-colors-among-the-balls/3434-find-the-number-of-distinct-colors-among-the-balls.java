class Solution {
    public int[] queryResults(int limit, int[][] queries) {

        HashMap<Integer,Integer> ballmap = new HashMap<>();
        HashMap<Integer,List<Integer>> colmap = new HashMap<>();
        int[] res = new int[queries.length];

        for(int i=0;i<queries.length;i++){

            if(ballmap.containsKey(queries[i][0])){

                int col = ballmap.get(queries[i][0]);
                colmap.get(col).remove(Integer.valueOf(queries[i][0]));
                if(colmap.get(col).size() == 0){

                    colmap.remove(col);
                }
            }

            ballmap.put(queries[i][0],queries[i][1]);

            if(!colmap.containsKey(queries[i][1])){
                colmap.put(queries[i][1],new ArrayList<Integer>());
            }

            colmap.get(queries[i][1]).add(queries[i][0]);

            res[i] = colmap.size();
        }

        return res;
    }
}