class Solution {
    public int longestNiceSubarray(int[] nums) {

        int res=1;
        int ornum=0;
        int low=0;
        int high=-1;
        int n = nums.length;


        while(++high < n){
            int currnum = nums[high];

            if((currnum & ornum) == 0){
                res= Math.max(res,(high-low)+1);
                ornum = ornum | currnum;
            }

            else{
                while(low < high){
                    ornum = ornum ^ nums[low++];
                    if((currnum & ornum) == 0){
                        break;
                    }
                }
                ornum = ornum | currnum;
            }
        }

        return res;
    }
}

/**

0011

 */