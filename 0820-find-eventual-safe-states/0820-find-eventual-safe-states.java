class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<Integer> res = new ArrayList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();

        for(int i=0;i<graph.length;i++){
            if(isSafeNode(i,visited,res,graph)){
            }
        }

        Collections.sort(res);
        return res;

    }

    public boolean isSafeNode(int curr, Set<Integer> visited, List<Integer> res, int[][] graph){

        if(res.contains(curr)){
            return true;
        }

        if(visited.contains(curr)){
            return false;
        }

        if(graph[curr].length == 0){
            res.add(curr);
            return true;
        }

        for(int temp: graph[curr]){
            visited.add(curr);
            if(!isSafeNode(temp,visited,res,graph)){
                return false;
            }
        }

        res.add(curr);
        return true;

    }

}