class Solution {
    public boolean isMatch(String s, String p) {
        return isMatchWorker(s.toCharArray(),p.toCharArray(),s.length()-1,p.length()-1);
    }

    public boolean isMatchWorker(char[] s, char[] p, int sIndex, int pIndex){
        if(sIndex < 0 && pIndex < 0){
            return true;
        }

        if(pIndex < 0){
            return false;
        }

        if(sIndex >= 0 && (s[sIndex] == p[pIndex] || p[pIndex] == '.')){
            return isMatchWorker(s,p,sIndex-1,pIndex-1);
        }

        if(p[pIndex] == '*'){
            boolean a = false;
            if(sIndex >= 0 && (s[sIndex] == p[pIndex-1] || p[pIndex-1] == '.')){
                a = isMatchWorker(s,p,sIndex-1,pIndex);
            }
            return isMatchWorker(s,p,sIndex,pIndex-2)||a;
        }

        return false;
    }
}