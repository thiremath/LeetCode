class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int ans=0,low=0,high=0,currsum=0;
        Set<Integer> set = new HashSet<>();

        while(high < nums.length){
            if(!set.contains(nums[high])){
                currsum+=nums[high];
                set.add(nums[high]);
                high++;
            }
            else{
                ans = Math.max(ans,currsum);
                set.remove(nums[low]);
                currsum-=nums[low++];
            }
        }

        return Math.max(ans,currsum);
    }
}