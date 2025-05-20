class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int ans = 0;
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]){{
            add(new int[]{0,k});
        }};

        int[][] edges = new int[n+1][n+1];

        for(int[] edge: edges){
            Arrays.fill(edge,-1);
        }

        for(int[] time: times){
            edges[time[0]][time[1]] = time[2];
        }

        boolean[] visited = new boolean[n+1];

        int N = n;

        while(!pq.isEmpty()){
            int curr = pq.peek()[1];
            // set.add(curr);
            int currDist = pq.poll()[0];
            if(visited[curr]) continue;
            visited[curr] = true;
            ans = currDist;
            N--;
            // System.out.println(N+" "+ans);
            // System.out.println("curr+currDist = "+curr+" "+currDist);
            for(int i=1;i<=n;i++){
                // System.out.println("edges[curr][i] + i "+edges[curr][i]+ " "+i);
                if(edges[curr][i] != -1 ){
                    // System.out.println("In");
                    pq.add(new int[]{currDist+edges[curr][i],i});
                }
                // System.out.println("out");
            }
        }

        // System.out.println(N+" "+ans);

        // System.out.println(calculatedDist);

        return (N != 0) ? -1 : ans;
    }
}