class Solution {
    List<List<Integer>> FinalRes;
    List<Integer> currRes;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        currRes = new ArrayList<>();
        FinalRes = new ArrayList<>();
        dfs(graph,0,new HashSet<>());
        return FinalRes;
    }

    public void dfs(int[][] graph, int node, Set<Integer> visitedSet){
        // visitedSet.add(node);
        currRes.add(node);

        if(node == graph.length-1){
            FinalRes.add(new ArrayList<>(currRes));
        }

        else{
            for(int adjNode:graph[node]){
                if(!visitedSet.contains(adjNode)){
                    dfs(graph,adjNode,visitedSet);
                }
            }
        }

        // visitedSet.remove(node);
        currRes.remove(currRes.size()-1);
    }
}