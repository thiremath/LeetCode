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

        // System.out.println("low,high = "+low+" "+high);

        if(dp[low][high] != null){
            return dp[low][high];
        }

        dp[low][high] = new ArrayList<>();

        String currst = s.substring(low,high+1);
        // System.out.println("currst = "+currst);

        if(set.contains(currst)){
            dp[low][high].add(currst);
        }

        for(int i=low+1;i<=high;i++){
            String curr = s.substring(low,i);
            // System.out.println("curr = "+curr);
            if(set.contains(curr)){
                System.out.println("currfound");
                List<String> next = wordBreakWorker(s,i,high);
                // System.out.println("next = "+next);
                if(next.size()!=0){
                    for(String st: next){
                        StringBuilder currans = new StringBuilder(curr).append(" ").append(st);
                        dp[low][high].add(String.valueOf(currans));   
                    }
                }
            }
        }

        return dp[low][high];
    }
}