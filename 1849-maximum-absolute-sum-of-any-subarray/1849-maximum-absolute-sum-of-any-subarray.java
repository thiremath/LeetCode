class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int minsum = Integer.MAX_VALUE;
        int maxsum = Integer.MIN_VALUE;
        int currminsum=0,currmaxsum=0;

        for(int num: nums){
            currmaxsum += num;
            currminsum += num;
            if(currmaxsum < num){
                currmaxsum = num;
            }
            if(currminsum > num){
                currminsum = num;
            }
            maxsum = Math.max(maxsum,currmaxsum);
            minsum = Math.min(minsum,currminsum);
        }

        return Math.max(maxsum,Math.abs(minsum));
    }
}

// 7,10,-1,3,4,-8,5