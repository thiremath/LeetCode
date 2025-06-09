class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return numDistinctWorker(s,t,0,0,dp);
    }

    public int numDistinctWorker(String s, String t, int sIndex, int tIndex, int[][] dp) {
        if(tIndex >= t.length()){
            return 1;
        }       
        if(sIndex >= s.length()){
            return 0;
        }

        if(dp[sIndex][tIndex] != -1){
            return dp[sIndex][tIndex];
        }

        int ans=0;

        if(s.charAt(sIndex) == t.charAt(tIndex)){
            ans = numDistinctWorker(s,t,sIndex+1,tIndex+1,dp);
        }

        return dp[sIndex][tIndex] = ans+numDistinctWorker(s,t,sIndex+1,tIndex,dp);
    }
}