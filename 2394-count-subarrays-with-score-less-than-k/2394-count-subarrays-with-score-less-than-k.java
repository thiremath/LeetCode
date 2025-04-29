class Solution {
    public long countSubarrays(int[] nums, long k) {
        long res = 0;
        int len = nums.length;
        int j=0;
        long sum = 0;

        for(int i=0;i<len;i++){
            sum += nums[i];
            while(i >= j && sum*(i-j+1) >= k){
                sum -= nums[j];
                j++;
            }
            res += (i-j+1);
        }

        return res;

    }
}