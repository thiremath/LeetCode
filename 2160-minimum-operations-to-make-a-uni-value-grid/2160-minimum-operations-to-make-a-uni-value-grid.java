class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] falttenedGrid = new int[grid.length*grid[0].length];
        int res = 0;

        int index=0;
        int temp = grid[0][0] % x;

        // System.out.println("temp = "+temp);

        for(int[] innergrid: grid){
            for(int ele: innergrid){
                // System.out.println(ele % x);
                if(ele % x != temp){
                    return -1;
                }
                falttenedGrid[index++] = ele;
            }
        }

        Arrays.sort(falttenedGrid);

        int n = falttenedGrid.length;

        // if(n % 2 == 0){
        //     temp = (falttenedGrid[n/2] + falttenedGrid[(n/2)-1]) / 2;
        // }

        // else{
            temp = falttenedGrid[n/2];
        // }

        // System.out.println("temp = "+temp);

        for(int ele: falttenedGrid){
            int curr = ele;
            if(curr != temp){
                while(curr > temp){
                    curr -= x;
                    res++;
                }

                while(curr < temp){
                    curr += x;
                    res++;
                }
            }
        }

        return res;

    }
}

/**

[[2,5],[8,5]]
x=3

2,2,2,3,4,5,6,6


 */