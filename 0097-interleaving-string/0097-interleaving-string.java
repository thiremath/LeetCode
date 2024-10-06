class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        if(s1.length()+s2.length() != s3.length()){
            return false;
        }
        return isInterleaveWorker(s1,s2,s3,0,0,0,dp);
    }

    public boolean isInterleaveWorker(String s1, String s2, String s3, int i, int j, int k,int[][] dp) {

        boolean res = false;

        if(k == s3.length()){
            if(i == s1.length() && j == s2.length()){
                dp[i][j] = 1;
            }
            else{
                dp[i][j] = 0; 
            }
        }

        if(dp[i][j] == -1){

            if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
                res = isInterleaveWorker(s1,s2,s3,i+1,j,k+1,dp);
            }

            if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
                res = res || isInterleaveWorker(s1,s2,s3,i,j+1,k+1,dp);
            }

            if(res){
                dp[i][j] = 1;
            }

            else{
                dp[i][j] = 0;
            }
        }

        if(dp[i][j] == 1){
            return true;
        }
        return false;
        
    }

}