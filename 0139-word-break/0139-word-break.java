class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String curr: wordDict){
            set.add(curr);
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        if(wordBreakWorker(s,wordDict,0,0,dp,set) == 1){
            return true;
        }
        return false;
    }

    public int wordBreakWorker(String s, List<String> wordDict,int start,int end,int[] dp, HashSet<String> set){

        if(end == s.length() || start == s.length()){
            return 0;
        }

        if(end == s.length()-1 && set.contains(s.substring(start,end+1))){
            return 1;
        }

        if(dp[start] == -1){

            if(set.contains(s.substring(start,end+1))){
                dp[start] = wordBreakWorker(s,wordDict,end+1,end+1,dp,set) | wordBreakWorker(s,wordDict,start,end+1,dp,set);
            }

            else{
                dp[start] = wordBreakWorker(s,wordDict,start,end+1,dp,set);
            }

        }

        return dp[start];
    }
}