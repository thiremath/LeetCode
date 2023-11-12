class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n] ;
        int temp = 1 ;
        int i;
        for(i=0;i<n;i++){
            ans[i] = temp ;
            temp *= nums[i] ;
        }
        temp = 1 ;
        for(i=n-1;i>=0;i--){
            ans[i] *= temp ;
            temp *= nums[i] ;
        }

        return ans ;
        
    }
}