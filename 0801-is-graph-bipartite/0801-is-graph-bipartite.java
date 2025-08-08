class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] NodeColors = new int[n];
        Arrays.fill(NodeColors,-1);

        for(int i=0;i<n;i++){
            if(NodeColors[i]==-1 && !dfs(graph,i,0,NodeColors)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int[][] graph, int currNode, int color, int[] NodeColors){

        if(NodeColors[currNode] != -1){
            return NodeColors[currNode]==color;
        }

        NodeColors[currNode] = color;

        for(int node: graph[currNode]){
            if(!dfs(graph,node,1-color,NodeColors)){
                return false;
            }
        }

        return true;
    }
}