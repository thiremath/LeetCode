class Solution {
    public int[][] merge(int[][] intervals) {

        boolean[][] edges = new boolean[intervals.length][intervals.length];
        boolean[] isconn = new boolean[intervals.length];
        ArrayList<int[]> ls = new ArrayList<int[]>();

        for(int i=0;i<intervals.length-1;i++){

            int a1 = intervals[i][0];
            int a2 = intervals[i][1];

            for(int j=i+1;j<intervals.length;j++){

                int a3 = intervals[j][0];
                int a4 = intervals[j][1];

                if(a1 > a3){
                    if(a4 < a1){
                        continue;
                    }
                }
                else if(a1 < a3){
                    if(a2 < a3){
                        continue;
                    }
                }
                isconn[i] = true;
                isconn[j] = true;
                edges[i][j] = true;
                edges[j][i] = true;
            }
        }

        boolean[] conn = Arrays.copyOf(isconn,isconn.length);
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i=0;i<edges.length;i++){

            int min = intervals[i][0];
            int max = intervals[i][1];
            if(conn[i]){

                for(int j=i+1;j<edges.length;j++){
                    if(conn[j]){
                        if(edges[i][j]){
                            isconn[i] = false;
                            min = Math.min(min,intervals[j][0]);
                            max = Math.max(max,intervals[j][1]);
                            edges[i][j] = false;
                            edges[j][i] = false;
                            q.add(j);
                            while(q.size() > 0){
                                int k = q.remove();
                                if(conn[k]){
                                    for(int x=0;x<edges.length;x++){

                                        if(edges[k][x]){
                                            System.out.println("hii");
                                            edges[k][x] = false;
                                            edges[x][k] = false;
                                            q.add(x);
                                            min = Math.min(min,intervals[x][0]);
                                            max = Math.max(max,intervals[x][1]);
                                        }
                                    }
                                }
                                conn[k] = false;
                            }
                        }
                    }
                }
            }
            conn[i] = false;

            if(!isconn[i]){
                int[] temp = new int[]{min,max};
                ls.add(temp);
            }
        }
        
        return ls.toArray(new int[ls.size()][]);
    }
}