class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp,-1);
        return mincostTicketsWorker(days,costs,0,0,dp);
    }

    public int mincostTicketsWorker(int[] days, int[] costs, int expiry, int index,int[] dp) {

        if(index == days.length){
            return 0;
        }

        int a=Integer.MAX_VALUE, b=Integer.MAX_VALUE, c=Integer.MAX_VALUE, d=Integer.MAX_VALUE;

        if(expiry != 0 && days[index] <= expiry){
            a = mincostTicketsWorker(days,costs,expiry,index+1,dp);
        }

        if(dp[index] == -1){

            b = costs[0] + mincostTicketsWorker(days,costs,days[index],index+1,dp);
            c = costs[1] + mincostTicketsWorker(days,costs,days[index]+6,index+1,dp);
            d = costs[2] + mincostTicketsWorker(days,costs,days[index]+29,index+1,dp);

            dp[index] = Math.min(a,Math.min(b,Math.min(c,d)));
        }

        return Math.min(dp[index],a);
    }
}