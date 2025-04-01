class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        long res=1;

        for(int i=n-1;i>=0;i--){
            int points = questions[i][0];
            int power = questions[i][1];
            dp[i] = points;
            if(i+power+1 <= n-1){
                dp[i] += dp[i+power+1];
            }
            dp[i] = Math.max(dp[i],res);
            res = dp[i];
        }

        return res;
    }
}