class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] ans = new int[n/3][3];
        Arrays.sort(nums);     

        for(int i=0;i<n;i+=3){
            if(nums[i+2]-nums[i] > k){
                return new int[0][0];
            }
            int[] temp = ans[i/3];
            temp[0] = nums[i];
            temp[1] = nums[i+1];
            temp[2] = nums[i+2];
        }


        return ans;
    }
}