class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Collections.singletonList(0);
        
        int ind[] = new int[n];
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] edge: edges) {
            ind[edge[0]]++;
            ind[edge[1]]++;
            map.putIfAbsent(edge[0], new ArrayList());
            map.putIfAbsent(edge[1], new ArrayList());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<ind.length;i++) {
            if(ind[i] == 1) {
                queue.add(i);
            }
        }

        int processed = 0;
        while(n - processed > 2) {
            int size = queue.size();
            processed += size;
            for(int i=0;i<size;i++) {
                int poll = queue.poll();
                for(int adj: map.get(poll)) {
                    if(--ind[adj] == 1) {
                        queue.add(adj);
                    }
                }
            }
        }

        List<Integer> list = new ArrayList();
        list.addAll(queue);
        return list;
    }
}



// class Solution {
//     public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//         // boolean[][] arr = new boolean[n][n];
//         List<HashSet<Integer>> adj = new ArrayList<>();
//         List<Integer> ans = new ArrayList<Integer>();
//         int[] degree = new int[n];
//         Queue<Integer> queue = new LinkedList<>();

//         if(n == 1){
//             ans.add(0);
//             return ans;
//         }

//         for(int i=0;i<n;i++){
//             adj.add(new HashSet<>());
//         }

//         for(int[] x: edges){
//             adj.get(x[0]).add(x[1]);
//             adj.get(x[1]).add(x[0]);
//             // arr[x[0]][x[1]] = true;
//             // arr[x[1]][x[0]] = true;
//             degree[x[0]]++;
//             degree[x[1]]++;
//         }

//         for(int i=0;i<degree.length;i++){
//             if(degree[i] == 1){
//                 queue.add(i);
//             }
//         }

//         while(n > 2){
//             int size = queue.size();
//             n-=size;
//             while(size-- > 0){
//                 int curr = queue.poll();
//                 for(int i=0;i<adj.get(curr).size();i++){
//                     if(adj.get(curr).contains(i)){
//                         degree[i]--;
//                         degree[curr]--;
//                         if(degree[i] == 1){
//                             queue.add(i);
//                         }
//                     }
//                 }
//             }
//         }

//         ans.addAll(queue);
        
//         return ans;

//     }
// }