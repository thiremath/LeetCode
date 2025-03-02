class Solution {
    public int[] applyOperations(int[] nums) {

        for(int i=0;i<nums.length-1;i++){
            if(nums[i] != 0){
                if(nums[i] == nums[i+1]){
                    nums[i]*=2;
                    nums[i+1]=0;
                }
            }
        }

        int zero=0;

        while(zero < nums.length && nums[zero]!=0){
            zero++;
        }

        int nonzero = zero;

        while(nonzero < nums.length){

            while(++nonzero < nums.length && nums[nonzero]==0){}

            if(nonzero >= nums.length){
                break;
            }

            int temp = nums[nonzero];
            nums[nonzero] = nums[zero];
            nums[zero] = temp;

            zero++;
        }

        return nums; 
    }
}