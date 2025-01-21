class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        ArrayList<Integer>[] indices = new ArrayList[arr.length+1];
        ArrayList<Integer> indexlist = new ArrayList<>();

        int[] rowfeq = new int[mat.length];
        int[] colfeq = new int[mat[0].length];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                indexlist = new ArrayList<>();
                indexlist.add(i);
                indexlist.add(j);
                indices[mat[i][j]] = indexlist;
            }
        }

        int temp=0;

        for(int curr: arr){
            // System.out.println(curr);
            // System.out.println(indices[curr].get(0));
            // System.out.println(indices[curr].get(1));
            // System.out.println();
            if(++rowfeq[indices[curr].get(0)] == colfeq.length || ++colfeq[indices[curr].get(1)] == rowfeq.length){
                // System.out.println(rowfeq[indices[curr].get(0)]);
                // System.out.println(colfeq[indices[curr].get(1)]);
                break;
            }
            temp++;
        }

        return temp;

    }
}