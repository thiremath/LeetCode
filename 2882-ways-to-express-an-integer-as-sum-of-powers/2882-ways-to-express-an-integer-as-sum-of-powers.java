class Solution {
    public int numberOfWays(int n, int x) {
        List<Integer> powers = new ArrayList<>();
        for(int i=1;i<=n;i++){
            int temp = (int)Math.pow(i,x);
            if(temp > n){
                break;
            }
            powers.add(temp);
        }

        Integer[][] dp = new Integer[powers.size()][301];

        return numberOfWaysWorker(powers,0,n,dp);
    }

    public int numberOfWaysWorker(List<Integer> powers, int index, int n, Integer[][] dp) {

        if(n==0){
            return 1;
        }

        if(index == powers.size() || n<0){
            return 0;
        }

        if(dp[index][n] != null){
            return dp[index][n];
        }

        int ans = 0;

        if(n > 0){
            long res = (numberOfWaysWorker(powers,index+1,n-powers.get(index),dp)+ numberOfWaysWorker(powers,index+1,n,dp))%1000000007;
            ans = (int) res;
        }

        return dp[index][n]=ans;

    }
}