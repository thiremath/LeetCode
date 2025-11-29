class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int low=0,high=n-1,res=0;

        if(height.length < 2) return 0;

        while(low<high){
            int currArea = (high-low)*Math.min(height[low],height[high]);
            res = Math.max(res,currArea);
            if(height[low] <= height[high]){
                low++;
            }
            else{
                high--;
            }
        }

        return res;
    }
}