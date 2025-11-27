class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        // can open a bracket when n > 0
        // can close a bracket when openbrackets>0
        // when n==0 && openbrackets==0 push string to res

        res = new ArrayList<>();
        if(n==0) return res;

        generateParenthesisWorker(n,0,new StringBuilder());

        return res;
    }

    public void generateParenthesisWorker(int n, int currOpenBrackets, StringBuilder currRes) {
        if(n==0 && currOpenBrackets==0){
            res.add(String.valueOf(currRes));
            return;
        }

        if(n > 0){
            currRes.append("(");
            generateParenthesisWorker(n-1,currOpenBrackets+1,currRes);
            currRes.deleteCharAt(currRes.length()-1);
        }

        if(currOpenBrackets>0){
            currRes.append(")");
            generateParenthesisWorker(n,currOpenBrackets-1,currRes);
            currRes.deleteCharAt(currRes.length()-1);
        }
    }
}