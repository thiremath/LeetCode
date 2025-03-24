class Solution {
    public int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings,(x,y) -> Integer.compare(x[0],y[0]));

        int temp = -1;

        for(int[] meeting: meetings){

            if(meeting[0] <= temp){
                
                if(meeting[1] <= temp){
                    continue;
                }
    
                meeting[0] = temp + 1;
            }

            temp = meeting[1];

            days -= (temp-meeting[0])+1;

        }

        return days;
    }
}

/**

[[1,3],[2,3],[2,5],[8,15],[10,13]]

 */