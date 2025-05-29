class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int m = edges1.length+1;
        int n = edges2.length+1;

        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();

        for(int i=0;i<m;i++){
            adj1.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            adj2.add(new ArrayList<>());
        }

        for(int[] edge1: edges1){
            adj1.get(edge1[0]).add(edge1[1]);
            adj1.get(edge1[1]).add(edge1[0]);
        }

        for(int[] edge2: edges2){
            adj2.get(edge2[0]).add(edge2[1]);
            adj2.get(edge2[1]).add(edge2[0]);
        }

        int targets_e2 = 0;

        if(k > 0){

            for(int i=0;i<n;i++){
                targets_e2 = Math.max(targets_e2,1+dfs(adj2,i,-1,k-1));
            }

        }

        int[] ans = new int[m]; 

        for(int i=0;i<m;i++){
            ans[i] = 1+targets_e2+dfs(adj1,i,-1,k);
        }

        return ans;

    }

    public int dfs(List<List<Integer>> adj, int i, int callerNode, int k){
        if(k == 0){
            return 0;
        }

        int target=0;

        for(Integer curradj: adj.get(i)){
            if(curradj != callerNode){
                target += 1 + dfs(adj,curradj,i,k-1);
            }
        }

        return target;
    }


}