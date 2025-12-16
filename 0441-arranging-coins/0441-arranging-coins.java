class Solution {
    public int arrangeCoins(int n) {
        int res = 0;
        int numberOfCoinsOnStairCase = 1;

        while(n >= numberOfCoinsOnStairCase){
            res++;
            n -= numberOfCoinsOnStairCase;
            numberOfCoinsOnStairCase++;
        }

        return res;
    }
}