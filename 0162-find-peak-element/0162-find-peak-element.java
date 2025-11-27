class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low=0,high=n-1;

        while(low<high){
            int mid = (low+high)/2;
            int left = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;

            if(mid > 0){
                left = nums[mid-1];
            }

            if(mid < nums.length-1){
                right = nums[mid+1];
            }

            if(nums[mid] > Math.max(left,right)){
                return mid;
            }

            else if(nums[mid] < right){
                low = mid+1;
            }

            else{
                high = mid-1;
            }
        }

        return low;
    }
}