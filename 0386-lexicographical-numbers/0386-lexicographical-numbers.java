class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();

        for(int i=1;i<=9;i++){
            dfs(n,ans,i);
        }

        return ans;
    }

    public void dfs(int n, List<Integer> ans, int curr){
        if(curr > n){
            return;
        }
        ans.add(curr);
        curr*=10;
        for(int i=0;i<=9;i++){
            if(curr+i <= n){
                dfs(n,ans,curr+i);
            }
            else{
                break;
            }
        }
    }
}