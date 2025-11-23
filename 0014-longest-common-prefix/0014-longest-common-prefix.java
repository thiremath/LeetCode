class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;

        if(n==0) return "";
        if(n==1) return strs[0];

        String res = strs[0];

        for(int i=1;i<n;i++){
            res = findCommonPrefix(strs[i],res);
        }

        return res;
    }

    public String findCommonPrefix(String a, String b){
        int n = Math.min(a.length(),b.length());

        if(n==0) return "";

        for(int i=0;i<n;i++){
            if(a.charAt(i)!=b.charAt(i)){
                return a.substring(0,i);
            }
        }

        return (a.length() > b.length()) ? b : a;
    }
}