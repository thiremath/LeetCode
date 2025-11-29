class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        if(n==0) return false;
        nums[n-1] = 1;

        for(int i=n-2;i>=0;i--){
            int currJump = nums[i];
            nums[i] = -1;
            for(int j=i+1;j<=i+currJump;j++){
                if(nums[j] == 1){
                    nums[i] = 1;
                    break;
                }
            }
        }

        return nums[0] == 1;
    }
}