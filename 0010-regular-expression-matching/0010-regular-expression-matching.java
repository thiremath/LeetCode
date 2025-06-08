enum Result{
    TRUE,
    FALSE
}

class Solution {
    Result[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Result[s.length()][p.length()];
        return isMatchWorker(s.toCharArray(),p.toCharArray(),s.length()-1,p.length()-1);
    }

    public boolean isMatchWorker(char[] s, char[] p, int sIndex, int pIndex){
        if(sIndex < 0 && pIndex < 0){
            return true;
        }

        if(pIndex < 0){
            return false;
        }

        if(sIndex >= 0 && dp[sIndex][pIndex] != null){
            return dp[sIndex][pIndex] == Result.TRUE;
        }

        if(sIndex >= 0 && (s[sIndex] == p[pIndex] || p[pIndex] == '.')){
            dp[sIndex][pIndex] = (isMatchWorker(s,p,sIndex-1,pIndex-1)) ? Result.TRUE : Result.FALSE;
        }

        if(p[pIndex] == '*'){
            boolean a = false;
            if(sIndex >= 0 && (s[sIndex] == p[pIndex-1] || p[pIndex-1] == '.')){
                a = isMatchWorker(s,p,sIndex-1,pIndex);
            }
            boolean b = isMatchWorker(s,p,sIndex,pIndex-2)||a;
            if(sIndex >= 0){
                dp[sIndex][pIndex] = (b) ? Result.TRUE : Result.FALSE;
            }
            return b;
        }

        if(sIndex >= 0){
            return dp[sIndex][pIndex] == Result.TRUE;
        }

        return false;
    }
}