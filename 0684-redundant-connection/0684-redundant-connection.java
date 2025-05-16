class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        for(int[] currEdge: edges){

            int a = currEdge[0];
            int b = currEdge[1];

            if(findParent(a,parent) == findParent(b,parent)){
                return new int[]{a,b};
            }

            union(a,b,parent);

        }

        return null;
    }

    public int findParent(int n, int[] parent){

        if(parent[n] == n){
            return n;
        }

        return findParent(parent[n],parent);
    }

    public void union(int i, int j, int[] parent){

        int a = findParent(i,parent);
        int b = findParent(j,parent);

        parent[a] = b;
    }
}