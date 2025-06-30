class Solution {
    public int findLHS(int[] nums) {
        int maxLen= 0,low=0,high=1;
        Arrays.sort(nums);
        while(high < nums.length){
            while(high < nums.length && nums[high]-nums[low] <= 1){
                if(nums[high]-nums[low] == 1){
                    maxLen = Math.max(maxLen, high-low+1);
                }
                high++;
            }
            while(low < nums.length-1 && nums[low]==nums[low+1]){
                low++;
            }

            if(high < nums.length && low < nums.length && nums[high]-nums[low] > 1){
                low++;
                // high++;
            }
            
        }

        return maxLen;
    }
}

// 1,1,2,2,2,3,3,5,7
// 1,5,6,7