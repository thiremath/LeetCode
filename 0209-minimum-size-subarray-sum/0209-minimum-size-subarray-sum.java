class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int low=0,high=0;

        while(!(low > high || low >= nums.length || high >= nums.length)){
            if(target-nums[high] > 0){
                target-=nums[high];
                high++;
            }
            else{
                target+=nums[low];
                ans = Math.min(ans,high-low+1);
                low++;
            }
        }

        if(ans == Integer.MAX_VALUE){
            ans = 0;
        }

        return ans;
    }

    // public int minSubArrayLenWorker(int target, int[] nums, int low, int high) {
    //     // if(low > high || low >= nums.length || high >= nums.length){
    //     //     return Integer.MAX_VALUE;
    //     // }

    //     // int ans = Integer.MAX_VALUE;

    //     // while(!(low > high || low >= nums.length || high >= nums.length)){
    //     //     if(target-nums[high] > 0){
    //     //         target-=nums[high];
    //     //         high++;
    //     //     }
    //     //     else{
    //     //         target+=nums[low];
    //     //         ans = Math.min(ans,high-low+1);
    //     //         low++;
    //     //     }
    //     // }

    //     // return ans;

    //     // if(target-nums[high] > 0){
    //     //     return minSubArrayLenWorker(target-nums[high],nums,low,high+1);
    //     // }

    //     // return Math.min( high-low+1,minSubArrayLenWorker(target+nums[low],nums,low+1,high) );
    // }
}