class Solution {
    public int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings, (x, y) -> {
            int cmp = Integer.compare(x[0], y[0]);
            return cmp != 0 ? cmp : Integer.compare(x[1], y[1]);
        });

        int index=0;
        int temp = -1;

        while(index < meetings.length){

            if(meetings[index][0] <= temp){
                
                if(meetings[index][1] <= temp){
                    index++;
                    continue;
                }
    
                meetings[index][0] = temp + 1;
            }

            temp = meetings[index][1];

            days -= (temp-meetings[index][0])+1;

        }

        return days;
    }
}

/**

[[1,3],[2,3],[2,5],[8,15],[10,13]]

 */