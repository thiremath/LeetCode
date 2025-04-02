class Solution {
    public long maximumTripletValue(int[] nums) {

        long res = 0;

        int n = nums.length;
        int[] max = new int[n];
        int maxval = Integer.MIN_VALUE;
        
        for(int i=n-1;i>=0;i--){

            if(nums[i] > maxval){
                maxval = nums[i];
            }
            max[i] = maxval;
        }

        // for(int i:min){
        //     System.out.print(i+" ");
        // }

        // System.out.println("");

        // for(int i:max){
        //     System.out.print(i+" ");
        // }


        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                // System.out.println("res,i,j,max = "+res+" "+i+" "+j+" "+max[j+1]);
                res = Math.max(res, (long)(nums[i]-nums[j]) * max[j+1]);
            }
        }

        return res;
    }
}