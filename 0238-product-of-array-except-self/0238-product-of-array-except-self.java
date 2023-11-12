class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n] ;
        int temp = 1 ;
        for(int i=0;i<n;i++){
            ans[i] = temp ;
            temp *= nums[i] ;
        }
        temp = 1 ;
        for(int j=n-1;j>=0;j--){
            ans[j] *= temp ;
            temp *= nums[j] ;
        }

        return ans ;
        
    }
}