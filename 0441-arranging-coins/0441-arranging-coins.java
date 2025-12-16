class Solution {
    public int arrangeCoins(int n) {
        int res = 1;

        while(n >= res){
            n -= res;
            res++;
        }

        return res-1;
    }
}