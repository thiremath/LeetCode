// class Solution {
//     public boolean isMatch(String s, String p) {
//         char[] sarr = s.toCharArray();
//         char[] parr = p.toCharArray();

//         int slen = sarr.length,plen = parr.length;
//         boolean[][] dp = new boolean[sarr.length+1][parr.length+1];

//         // Arrays.fill(dp[sarr.length],true);

//         // for(int i=0;i<=sarr.length;i++){
//         //     dp[i][parr.length] = true;
//         // }

//         dp[sarr.length][parr.length] = true;

//         int starcount=0;

//         while(--plen >= 0){
//             if(parr[plen] == '*'){
//                 starcount++;
//             }
//         }

//         if(starcount == parr.length){
//             return true;
//         }

//         // // s-1,p-1
//         // int prevtempa = false;
//         // int tempa = false;
//         // // s-1,p
//         // int prevtempb = false;
//         // int tempb = false;
//         // // s,p-1
//         // int prevtempc = false;
//         // int tempc = false;

//         for(int i=slen-1;i>=0;i--){
//             for(int j=plen-1;j>=0;j--){
//                 if(sarr[i] == parr[j] || parr[j] == '*' || parr[j] == '?'){
//                     dp[i][j] = dp[i+1][j+1];
//                     if(parr[j] == '*' ){
//                         // dp[i][j] = true;
//                         dp[i][j] = dp[i][j] || dp[i+1][j] || dp[i][j+1];
//                     }
//                 }
//                 else{
//                     dp[i][j] = false;
//                 }
//             }
//             // prevtempa = tempa;
//             // prevtempb = tempb;
//             // prevtempc = tempc;
//         }

//         for(int i=0;i<=slen;i++){
//             for(int j=0;j<=plen;j++){
//                 System.out.print(dp[i][j]+"|");
//             }
//             System.out.println("");
//         }

//         return dp[0][0];
//     }
// }

class Solution {
    public boolean isMatch(String s, String p) {
        char[] sarr = s.toCharArray();
        char[] parr = p.toCharArray();

        int slen = sarr.length,plen = parr.length;
        boolean[][] dp = new boolean[sarr.length+1][parr.length+1];

        // Arrays.fill(dp[sarr.length],true);

        // for(int i=0;i<=sarr.length;i++){
        //     dp[i][parr.length] = true;
        // }

        dp[sarr.length][parr.length] = true;

        // int starcount=0;

        // while(--plen >= 0){
        //     if(parr[plen] == '*'){
        //         starcount++;
        //     }
        // }

        // if(starcount == parr.length){
        //     return true;
        // }

        // plen = parr.length;

        for (int j = plen - 1; j >= 0; j--) {
            if (parr[j] == '*') {
                dp[slen][j] = dp[slen][j + 1]; // '*' can match empty
            }
        }

        // // s-1,p-1
        // int prevtempa = false;
        // int tempa = false;
        // // s-1,p
        // int prevtempb = false;
        // int tempb = false;
        // // s,p-1
        // int prevtempc = false;
        // int tempc = false;

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
            // prevtempa = tempa;
            // prevtempb = tempb;
            // prevtempc = tempc;
        }

        // for(int i=0;i<=slen;i++){
        //     for(int j=0;j<=plen;j++){
        //         System.out.print(dp[i][j]+"|");
        //     }
        //     System.out.println("");
        // }

        return dp[0][0];
    }
}