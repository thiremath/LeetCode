class Solution {
    List<String>[][] dp;
    Set<String> set;

    public List<String> wordBreak(String s, List<String> wordDict) {
        dp = new ArrayList[s.length()][s.length()];
        set=new HashSet<>();
        set.addAll(wordDict);
        return wordBreakWorker(s,0,s.length()-1);
    }

    public List<String> wordBreakWorker(String s, int low, int high) {

        if(dp[low][high] != null){
            return dp[low][high];
        }

        dp[low][high] = new ArrayList<>();

        String currst = s.substring(low,high+1);

        if(set.contains(currst)){
            dp[low][high].add(currst);
        }

        for(int i=low+1;i<=high;i++){
            String curr = s.substring(low,i);
            if(set.contains(curr)){
                List<String> next = wordBreakWorker(s,i,high);
                for(String st: next){
                    dp[low][high].add(curr+" "+st);   
                }
            }
        }

        return dp[low][high];
    }
}