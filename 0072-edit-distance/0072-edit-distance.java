class Solution {
    public int minDistance(String word1, String word2) {
        // int[][] dp = new int[word1.length()+1][word2.length()+1];
        // // boolean[][] isrequired = new boolean[word1.length()+1][word2.length()+1];

        // for(int i=0;i<dp.length;i++){
        //     dp[i][0] = i;
        // }

        // for(int i=0;i<dp[0].length;i++){
        //     dp[0][i] = i;
        // }

        // dp[word1.length()][word2.length()] = -1;

        // for(int i=dp.length-1;i>=1;i--){
        //     for(int j=dp[0].length-1;j>=1;j--){
        //         if(dp[i][j] == -1){
        //             if(word1.charAt(i-1) != word2.charAt(j-1)){
        //                 dp[i-1][j] = -1;
        //                 dp[i][j-1] = -1;
        //             }
        //             dp[i-1][j-1] = -1;
        //         }
        //     }
        // }

        // for(int i=1;i<dp.length;i++){
        //     for(int j=1;j<dp[i].length;j++){
        //         if(dp[i][j] == -1){
        //             if(word1.charAt(i-1) == word2.charAt(j-1)){
        //                 dp[i][j] = dp[i-1][j-1];
        //             }
        //             else{
        //                 dp[i][j] = 1 + Math.min( Math.min( dp[i-1][j],dp[i][j-1] ),dp[i-1][j-1] );
        //             }
        //         }
        //     }
        // }


        // return dp[word1.length()][word2.length()];

        int[][] dp = new int[word1.length()+1][word2.length()+1] ;

        for(int[] i: dp){
            Arrays.fill(i,-1);
        }

        return minDistWorker(word1,word2,word1.length(),word2.length(),dp);


    }

    public int minDistWorker(String word1, String word2, int i, int j, int[][] dp) {

        if(dp[i][j] == -1){
            if(i == 0){
                dp[i][j] = j;
            }

            else if(j == 0){
                dp[i][j] = i;
            }

            else if(word1.charAt(i-1) == word2.charAt(j-1)){
                dp[i][j] = minDistWorker(word1,word2,i-1,j-1,dp);
            }

            else{
                dp[i][j] = 1 + Math.min( minDistWorker(word1,word2,i-1,j-1,dp), Math.min( minDistWorker(word1,word2,i-1,j,dp), minDistWorker(word1,word2,i,j-1,dp) ) );
            }
        }

        return dp[i][j] ;

    }

}