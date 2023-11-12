class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n] ;
        int[] postfix = new int[n] ;
        int[] ans = new int[n] ;
        prefix[0] = nums[0] ;
        postfix[n-1] = nums[n-1] ;
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] * nums[i] ;
        }
        for(int j=n-2;j>=0;j--){
            postfix[j] = postfix[j+1] * nums[j] ;
            System.out.println(postfix[j]+" "+nums[1]) ;
        }
        System.out.println(nums[1]) ;
        System.out.println(nums[1]+" "+postfix[1]) ;
        ans[0] = postfix[1] ;
        ans[n-1] = prefix[n-2] ;

        for(int k=1;k<=n-2;k++){
            ans[k] = prefix[k-1] * postfix[k+1] ;
        }
        return ans ;
        
    }
}