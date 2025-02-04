class Solution {
    public int maxAscendingSum(int[] nums) {

        int res=nums[0],temp=nums[0];
        for(int i=0;i<nums.length-1;i++){

            if(nums[i+1] > nums[i]){

                temp+=nums[i+1];
            }
            else{

                res = Math.max(res,temp);
                temp=nums[i+1];
            }
        }
        return Math.max(res,temp);
    }
}