class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] temp: dp){
            Arrays.fill(temp,-1);
        }
        return lcsWorker(text1,text2,0,0,dp);
    }

    public int lcsWorker(String text1, String text2, int index1, int index2, int[][] dp) {
        if(index1 == text1.length() || index2 == text2.length()){
            return 0;
        }

        if(dp[index1][index2] == -1){

            if(text1.charAt(index1) == text2.charAt(index2)){
                dp[index1][index2] = 1 + lcsWorker(text1,text2,index1+1,index2+1,dp);
            }

            else{
                dp[index1][index2] = Math.max(lcsWorker(text1,text2,index1+1,index2,dp), lcsWorker(text1,text2,index1,index2+1,dp));
            }
        }

        return dp[index1][index2];

    }
    
}