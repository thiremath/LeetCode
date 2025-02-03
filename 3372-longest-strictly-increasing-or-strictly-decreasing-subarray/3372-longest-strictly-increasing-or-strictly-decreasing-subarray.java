class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int index=0,res=1,temp=1;

        while(index < nums.length-1){

            if(nums[index+1] > nums[index]){
                while(index < nums.length-1 && nums[index+1] > nums[index]){
                    temp++;
                    index++;
                }
                res = Math.max(res,temp);
                temp=1;
            }

            else if(nums[index+1] < nums[index]){

                while(index < nums.length-1 && nums[index+1] < nums[index]){
                    temp++;
                    index++;
                }
                res = Math.max(res,temp);
                temp=1;
            }

            else{
                index++;
            }

        }
        return res;
    }
}