class Solution {
    List<String> ans;
    StringBuilder currAns;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        currAns = new StringBuilder("");

        backtrack(n,0);
        return ans;
    }

    public void backtrack(int n, int pairsOpen){

        if(n == 0 && pairsOpen == 0){
            ans.add(currAns.toString());
        }

        if(n > 0){
            currAns.append("(");
            backtrack(n-1,pairsOpen+1);
            currAns.deleteCharAt(currAns.length()-1);
        }

        if(pairsOpen > 0){
            currAns.append(")");
            backtrack(n,pairsOpen-1);
            currAns.deleteCharAt(currAns.length()-1);
        }
    }
}