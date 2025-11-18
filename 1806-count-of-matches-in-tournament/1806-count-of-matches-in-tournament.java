class Solution {
    public int numberOfMatches(int n) {
        int res=0;

        while(n>1){
            res += (n/2);
            n = (int)Math.ceil((double)n/2);

        }

        return res;
    }
}

// res = 3+2+1
