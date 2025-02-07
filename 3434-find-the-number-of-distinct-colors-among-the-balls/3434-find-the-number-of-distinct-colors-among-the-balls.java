class Solution {
    public int[] queryResults(int limit, int[][] queries) {

        HashMap<Integer,Integer> ballmap = new HashMap<>();
        HashMap<Integer,List<Integer>> colmap = new HashMap<>();
        int resindex = 0;
        int[] res = new int[queries.length];

        for(int[] curr: queries){

            if(ballmap.containsKey(curr[0])){

                int col = ballmap.get(curr[0]);
                colmap.get(col).remove(Integer.valueOf(curr[0]));
                if(colmap.get(col).size() == 0){

                    colmap.remove(col);
                }
            }

            ballmap.put(curr[0],curr[1]);

            if(!colmap.containsKey(curr[1])){
                colmap.put(curr[1],new ArrayList<Integer>());
            }

            List<Integer> temp = colmap.get(curr[1]);
            temp.add(curr[0]);

            res[resindex++] = colmap.size();
        }

        return res;
    }
}