class Solution {
    public int subarraySum(int[] nums, int k) {
        /**
        
        [1,1,2,3,-2,1,4,7,9,10]
        k = 5

        [1,0,1,1,-5,3,3,3,2,1]

         */

         if(nums.length==0) return 0;

         int res=0,n=nums.length;

         for(int i=0;i<n;i++){

            int sum = nums[i];
            if(sum==k) res++;

            for(int j=i+1;j<n;j++){
                sum += nums[j];
                if(sum==k) res++;
            }

         }

         return res;
    }
}