class Solution {
    public boolean isMatch(String s, String p) {
        char[] sarr = s.toCharArray();
        char[] parr = p.toCharArray();

        int slen = sarr.length,plen = parr.length;
        boolean[][] dp = new boolean[slen+1][plen+1];

        dp[slen][plen] = true;

        for (int j = plen - 1; j >= 0; j--) {
            if (parr[j] == '*') {
                dp[slen][j] = dp[slen][j + 1];
            }
        }

        for(int i=slen-1;i>=0;i--){
            for(int j=plen-1;j>=0;j--){
                if(sarr[i] == parr[j] || parr[j] == '*' || parr[j] == '?'){
                    dp[i][j] = dp[i+1][j+1];
                    if(parr[j] == '*'){
                        dp[i][j] = dp[i][j] || dp[i+1][j] || dp[i][j+1];
                    }
                }
                else{
                    dp[i][j] = false;
                }
            }
        }

        return dp[0][0];
    }
}