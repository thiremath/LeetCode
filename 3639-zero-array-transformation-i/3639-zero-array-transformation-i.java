class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] differencearr = new int[n+1];
        int temp = 0;

        for(int[] query: queries){
            differencearr[query[0]]++;
            differencearr[query[1]+1]--;
        }

        // for(int i=0;i<=n;i++){
        //     System.out.print(differencearr[i]+" ");
        // }

        for(int i=0;i<n;i++){
            temp = differencearr[i] + temp;
            if(nums[i] > temp){
                return false;
            }
        }

        return true;

    }
}