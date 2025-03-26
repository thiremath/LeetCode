class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] falttenedGrid = new int[grid.length*grid[0].length];
        int res = 0;

        int index=0;
        int temp = grid[0][0] % x;

        for(int[] innergrid: grid){
            for(int ele: innergrid){
                if(ele % x != temp){
                    return -1;
                }
                falttenedGrid[index++] = ele;
            }
        }

        Arrays.sort(falttenedGrid);

        temp = falttenedGrid[falttenedGrid.length/2];

        for(int ele: falttenedGrid){
            res += Math.abs(ele-temp) / x;
        }

        return res;

    }
}

/**

[[2,5],[8,5]]
x=3

2,2,2,3,4,5,6,6


 */