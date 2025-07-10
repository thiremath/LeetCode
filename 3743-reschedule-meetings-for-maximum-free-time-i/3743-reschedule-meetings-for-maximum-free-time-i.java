class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int[] gaps = new int[startTime.length+1];
        int startIndex=0,temp=0,endIndex=0;

        while(startIndex < startTime.length){
            gaps[startIndex] = startTime[startIndex++]-temp;
            temp = endTime[endIndex++];
        }
        gaps[startIndex] = eventTime-temp;

        startIndex=0;endIndex=0;temp=0;

        while(endIndex != k+1){
            temp+=gaps[endIndex++];
        }

        int ans = temp;

        while(endIndex < gaps.length){
            temp-=gaps[startIndex++];
            temp+=gaps[endIndex++];
            ans = Math.max(ans,temp);
        }

        return ans;
    }
}