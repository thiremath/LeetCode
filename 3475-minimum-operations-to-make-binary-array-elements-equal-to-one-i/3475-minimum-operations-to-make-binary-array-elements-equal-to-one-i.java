class Solution {
    public int minOperations(int[] nums) {

        int zeros = 0;

        for(int num:nums){
            if(num == 0){
                zeros++;
            }
        }

        if(zeros == 0){
            return 0;
        }

        zeros = 0;

        int index=-1;

        while(++index <= nums.length-3){

            if(nums[index] == 0){
            
                zeros++;
                nums[index+1] = Math.abs(nums[index+1]-1);
                nums[index+2] = Math.abs(nums[index+2]-1);
            }
        }

        return (nums[nums.length-1] == 1 && nums[nums.length-2] == 1) ? zeros : -1 ;
    }
}