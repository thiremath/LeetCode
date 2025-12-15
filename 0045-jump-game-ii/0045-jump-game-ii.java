class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        nums[n-1] = 0;

        for(int i=n-2;i>=0;i--){
            if(nums[i]==0) nums[i] = Integer.MAX_VALUE;

            else{
                int minJumpToReach = Integer.MAX_VALUE;

                if(nums[i]+i >= n-1) nums[i] = 1;

                else{

                    for(int j=i+1;j<=i+nums[i];j++){
                        minJumpToReach = Math.min(minJumpToReach,nums[j]);
                    }

                    nums[i] = minJumpToReach;

                    if(minJumpToReach != Integer.MAX_VALUE){
                        nums[i]++;
                    }

                }
            }
        }

        if(nums[0] != Integer.MAX_VALUE){
            return nums[0];
        }

        return -1;
    }
}