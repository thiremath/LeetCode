class Solution {
    public int partitionArray(int[] nums, int k) {
        int ans=1;
        Arrays.sort(nums);

        int prev=nums[0];

        for(int i=0;i<nums.length;i++){
            if(nums[i] - prev > k){
                prev = nums[i];
                ans++;
            }
        }

        return ans;
    }
}