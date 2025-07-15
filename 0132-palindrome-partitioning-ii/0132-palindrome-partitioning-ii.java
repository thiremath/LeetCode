class Solution {
    Integer[][] dp;
    public int minCut(String s) {
        dp = new Integer[s.length()][s.length()];
        return minCutWorker(s,0,s.length()-1);
    }

    public int minCutWorker(String s,int low,int high) {

        if(dp[low][high] != null){
            return dp[low][high];
        }

        if(isPalindrome(s,low,high)){
            dp[low][high] = 0;
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for(int i=high;i>low;i--){
            if(isPalindrome(s,low,i-1)){
                ans = Math.min(ans,1+minCutWorker(s,i,high));
            }
        }

        return dp[low][high]=ans;   
    }

    public boolean isPalindrome(String s,int low,int high) {
        if(s.length() == 1){
            return true;
        }

        while(low < high){
            if(s.charAt(low++)!=s.charAt(high--)){
                return false;
            }
        }
        return true;
    }
}