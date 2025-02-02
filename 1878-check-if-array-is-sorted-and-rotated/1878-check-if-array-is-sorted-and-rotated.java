class Solution {
    public boolean check(int[] nums) {
        int len = nums.length;
        while(len > 1 && nums[0] == nums[len-1]){
            len--;
        }

        if(len != 1){

            int start=0;

            if(nums[0] > nums[len-1]){
                start=len-1;
                while(nums[start-1] <= nums[start]){
                    start--;
                }
            }

            for(int i=0;i<len-1;i++){
                if(nums[(start+i)%len] > nums[(start+i+1)%len]){
                    return false;
                }
            }

        }

        return true;
    }
}