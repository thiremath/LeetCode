class Solution {
    public int numOfSubarrays(int[] arr) {
        int res=0,even=0,odd=0;
        int mod = 1000000007;
        for(int x: arr){
            if(x % 2 == 0){
                even++;
            }
            else{
                int temp = odd;
                odd = 1 + even;
                even = temp;
            }
            res = (res+odd)%mod;
        }
        return res ;
    }
}