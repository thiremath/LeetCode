class Solution {
    public int countHillValley(int[] nums) {
        int ans=0;

        int index=0;

        while(index < nums.length-1 && nums[index] == nums[index+1]){
            index++;
        }

        int left = nums[index];

        for(int i=index+1;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1] && (nums[i] > left) == (nums[i] > nums[i+1])){
                left = nums[i];
                ans++;
            }
        }   

        return ans;
    }
}