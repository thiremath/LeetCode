class Solution {
    public boolean isMatch(String s, String p) {
        char[] sarr = s.toCharArray();
        char[] parr = p.toCharArray();

        int slen = sarr.length,plen = parr.length;

        boolean[] prev = new boolean[plen+1];
        prev[plen] = true;

        for (int j = plen - 1; j >= 0; j--) {
            if (parr[j] == '*') {
                prev[j] = prev[j + 1];
            }
        }

        for(int i=slen-1;i>=0;i--){
            boolean[] curr = new boolean[plen+1];
            for(int j=plen-1;j>=0;j--){
                if(sarr[i] == parr[j] || parr[j] == '*' || parr[j] == '?'){
                    curr[j] = prev[j+1];
                    if(parr[j] == '*'){
                        curr[j] = prev[j] || curr[j+1];
                    }
                }
                else{
                    curr[j] = false;
                }
            }
            prev = curr;
        }

        return prev[0];
    }
    
}