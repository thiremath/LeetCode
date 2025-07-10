class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int[] gaps = new int[startTime.length+1];
        int[] prefixmaxgap = new int[startTime.length+1];
        int[] postfixmaxgap = new int[startTime.length+1];

        int startIndex=0,temp=0,endIndex=0,Max=0,ans=0;

        while(startIndex < startTime.length){
            gaps[startIndex] = startTime[startIndex]-temp;
            Max = Math.max(Max,gaps[startIndex]);
            prefixmaxgap[startIndex++] = Max;
            temp = endTime[endIndex++];
        }
        gaps[startIndex] = eventTime-temp;

        Max=0;

        for(int i=gaps.length-1;i>=0;i--){
            Max = Math.max(Max,gaps[i]);
            postfixmaxgap[i] = Max;
        }

        for(int i=0;i<gaps.length-1;i++){
            int curr = endTime[i]-startTime[i];
            int currans=gaps[i]+gaps[i+1];
            if((i-1 >= 0 && prefixmaxgap[i-1]>=curr) || (i+2 < gaps.length && postfixmaxgap[i+2]>=curr)){
                currans+=curr;
            }
            ans = Math.max(ans,currans);
        }

        return ans;
    }
}