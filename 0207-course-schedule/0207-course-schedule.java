class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] arr = new boolean[numCourses][numCourses];
        boolean[] isVisited = new boolean[numCourses];
        int[] incoming = new int[numCourses];

        for(int[] x: prerequisites){
            arr[x[0]][x[1]] = true;
            incoming[x[1]]++;
        }

        // for(int i=0;i<incoming.length;i++){
        //     System.out.print(incoming[i]+" ");
        // }

        for(int i=0;i<incoming.length;i++){
            if(incoming[i] > 0){
                if(!isVisited[i] && isCyclic(arr,isVisited,new boolean[numCourses],i)){
                    return false;
                }

            }
        }

        return true;
    } 

    public boolean isCyclic(boolean[][] arr, boolean[] isVisited, boolean[] recStack, int curr){

        // System.out.print("Curr__  = "+curr+"\n");
        // for(int i=0;i<isVisited.length;i++){
        //     System.out.print(isVisited[i]+" ");
        // }
        // System.out.println("");
        // for(int i=0;i<isVisited.length;i++){
        //     System.out.print(recStack[i]+" ");
        // }
        // System.out.println("");

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
        return false;

    }
}
