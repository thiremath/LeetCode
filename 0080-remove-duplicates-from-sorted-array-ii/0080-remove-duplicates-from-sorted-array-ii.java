class Solution {
    public int removeDuplicates(int[] nums) {
        int low=0,high=0,temp=nums[0],count=0;

        while(high<nums.length){

            if(temp != nums[high]){
                temp = nums[high];
                count=0;
            }

            if(++count > 2){
                while(high<nums.length && temp == nums[high]){
                    high++;
                }
                continue;
            }

            if(low != high){
                nums[low] = nums[high];
            }
            low++;
            high++;

        }

        return low;
    }
}