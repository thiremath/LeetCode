class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;

        int currsum=0,res=nums[0];

        for(int num: nums){

            if(currsum < 0){
                currsum = 0;
            }

            currsum += num;
            res = Math.max(res,currsum);
        }

        return res;
    }
}

/**

[-2,1,-3,4,-1,2,1,-5,4]

try adding nums[i] to currsum

if currsum < 0
    currsum = 0

res = Math.max(res,currsum)

 */