class Solution {
    List<Integer> ans;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[][] arr = new boolean[numCourses][numCourses];
        boolean[] isVisited = new boolean[numCourses];
        int[] outgoing = new int[numCourses];
        ans = new ArrayList<>();

        // if(prerequisites.length == 0){
        //     return new int[]{};
        // }

        for(int[] x: prerequisites){
            arr[x[0]][x[1]] = true;
            outgoing[x[0]]++;
        }

        for(int i=0;i<outgoing.length;i++){
            if(outgoing[i] > 0){
                if(!isVisited[i] && isCyclic(arr,isVisited,new boolean[numCourses],i)){
                    return new int[0];
                }
            }
            if(!ans.contains(i)){
                ans.add(i);
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    } 

    public boolean isCyclic(boolean[][] arr, boolean[] isVisited, boolean[] recStack, int curr){

        if(recStack[curr]){
            return true;
        }

        if(!isVisited[curr]){

            isVisited[curr] = true;
            recStack[curr] = true;

            for(int i=0;i<arr[curr].length;i++){
                if(arr[curr][i] && isCyclic(arr,isVisited,recStack,i)){
                    return true;
                }
            }

        }

        recStack[curr] = false;

        if(!ans.contains(curr)){
            ans.add(curr);
        }

        return false;

    }
}