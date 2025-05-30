class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] distances_n1 = new int[n];
        int[] distances_n2 = new int[n];
        Arrays.fill(distances_n1,-1);
        Arrays.fill(distances_n2,-1);
        int ans = Integer.MAX_VALUE;
        int node=-1;

        bfs(node1,edges,distances_n1);
        bfs(node2,edges,distances_n2);

        for(int i=0;i<n;i++){
            int a = distances_n1[i];
            int b = distances_n2[i];
            if(a != -1 && b != -1){
                if(ans > Math.max(a,b)){
                    ans = Math.max(a,b);
                    node = i;
                }
            }
        }

        return node;
    }

    public void bfs(int node, int[] edges, int[] distances){

        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int ans = -1;

        queue.add(node);
        set.add(node);

        while(!queue.isEmpty()){
            int curr = queue.poll();
            distances[curr] = ++ans;
            if(!set.contains(edges[curr]) && edges[curr] != -1){
                set.add(edges[curr]);
                queue.add(edges[curr]);
            }
        }

    }
}