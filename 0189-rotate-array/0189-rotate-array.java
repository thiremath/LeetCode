class Solution {
    public void rotate(int[] nums, int k) {
        if(k >= nums.length){
            k = k % nums.length;
        }
        if(k > 0){
            swapper(nums,0,nums.length-1);
            swapper(nums,0,k-1);
            swapper(nums,k,nums.length-1);
        }
    }

    public void swapper(int[] nums,int a, int b){
        while(a < b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            a++;
            b--;
        }
    }
}