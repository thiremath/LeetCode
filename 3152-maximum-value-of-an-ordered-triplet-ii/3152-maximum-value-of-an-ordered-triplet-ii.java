class Solution {
    public long maximumTripletValue(int[] nums) {

        long res=0;
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int max=1;

        for(int i=0;i<n;i++){
            if(max < nums[i]){
                max = nums[i];
            }
            prefix[i] = max;
        }

        max=1;

        for(int i=n-1;i>=0;i--){
            if(max < nums[i]){
                max = nums[i];
            }
            suffix[i] = max;
        }

        for(int i=1;i<n-1;i++){
            res = Math.max(res,(long)suffix[i+1]*(prefix[i-1]-nums[i]));
        }

        return res;
    }
}