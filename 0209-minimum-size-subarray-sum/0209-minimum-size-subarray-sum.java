class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int temp = minSubArrayLenWorker(target,nums,0,0);
        if(temp == Integer.MAX_VALUE){
            return 0;
        }
        return temp;
    }

    public int minSubArrayLenWorker(int target, int[] nums, int low, int high) {
        if(low > high || low >= nums.length || high >= nums.length){
            return Integer.MAX_VALUE;
        }

        if(target-nums[high] > 0){
            return minSubArrayLenWorker(target-nums[high],nums,low,high+1);
        }

        return Math.min( high-low+1,minSubArrayLenWorker(target+nums[low],nums,low+1,high) );
    }
}