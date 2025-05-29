class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
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

        int[] blk_wht = new int[2];
        dfs(adj2,0,-1,true,blk_wht);
        int targets_e2 = Math.max(blk_wht[0],blk_wht[1]);

        // System.out.println(targets_e2);

        int[] ans = new int[m]; 

        blk_wht[0] = 0;
        blk_wht[1] = 0;

        dfs(adj1,0,-1,true,blk_wht);

        // System.out.println(blk_wht[0]);
        // System.out.println(blk_wht[1]);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);

        HashSet<Integer> set = new HashSet<>();

        boolean color = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- != 0){
                int curr = queue.poll();
                ans[curr] = targets_e2;
                if(color){
                    ans[curr]+=blk_wht[0];
                }
                else{
                    ans[curr]+=blk_wht[1];
                }
                for(Integer x: adj1.get(curr)){
                    if(!set.contains(x)){
                        set.add(x);
                        queue.add(x);
                    }
                }
            }
            color = !color;
        }

        return ans;

    }

    public void dfs(List<List<Integer>> adj, int i, int callerNode, boolean isWhite, int[] blk_wht){

        if(isWhite){
            blk_wht[0]++;
        }
        else{
            blk_wht[1]++;
        }
        
        for(Integer curradj: adj.get(i)){
            if(curradj != callerNode){
                dfs(adj,curradj,i,!isWhite,blk_wht);
            }
        }
    }


}