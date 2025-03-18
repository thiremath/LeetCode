class Solution {
    public int longestNiceSubarray(int[] nums) {

        int res=0;
        int ornum=0;
        int low=0;
        int high=-1;
        int n = nums.length;


        while(++high < n){
            int currnum = nums[high];
            // System.out.print("currnum = "+currnum+" ");

            if((currnum & ornum) == 0){
                // System.out.println("Inside if");
                ornum = ornum | currnum;
            }

            else{
                // System.out.println("Inside else");
                // ornum = ornum | currnum;
                while(low < high){
                    ornum = ornum ^ nums[low++];
                    if((currnum & ornum) == 0){
                        break;
                    }
                }
                ornum = ornum | currnum;
            }

            // System.out.println("");

            res= Math.max(res,(high-low)+1);
        }

        return res;
    }
}

/**

0011

 */