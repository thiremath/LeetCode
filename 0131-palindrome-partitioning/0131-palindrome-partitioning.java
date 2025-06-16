class Solution {
    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        partitionWorker(s,0,new ArrayList<>(),dp);
        return ans;
    }

    public void partitionWorker(String s,int index, List<String> curr, int[][] dp) {
        // System.out.println(curr);
        // System.out.println("ans "+ ans);

        if(index == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,dp,index,i)){
                curr.add(s.substring(index,i+1));
                partitionWorker(s,i+1,curr,dp);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int[][] dp, int l, int h){

        int low = l;
        int high = h;

        while(low <= high){
            if(dp[low][high] != -1){
                return dp[low][high] == 1;
            }
            if(s.charAt(low) != s.charAt(high)){
                dp[low][high] = 0;
                return false;
            }
            // dp[low][high] = 1;
            low++;
            high--;
        }

        dp[l][h] = 1;

        return true;
    }

    
}