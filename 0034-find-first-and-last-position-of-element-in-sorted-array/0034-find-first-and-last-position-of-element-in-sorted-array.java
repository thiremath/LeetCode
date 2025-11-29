class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(target == nums[mid]){
                int[] res = new int[2];
                res[0] = findFarthestIndex(nums,mid,true,low,high);
                res[1] = findFarthestIndex(nums,mid,false,low,high);
                return res;
            }

            else if(target < nums[mid]){
                high = mid - 1;
            }

            else{
                low = mid + 1;
            }
        }

        return new int[]{-1,-1};
    }

    public int findFarthestIndex(int[] nums, int index, boolean isLeftMostFarthest, int low, int high){
        int target = nums[index];
        int farthestIndex = index;

        // int low=0,high=0;

        // if(isLeftMostFarthest){
        //     low = 0;
        //     high = index-1;
        // }

        // else{
        //     low = index+1;
        //     high = nums.length-1;
        // }

        while(low <= high){
            int mid = low + (high-low)/2;

            if(target == nums[mid]){
                farthestIndex = mid;

                if(isLeftMostFarthest){
                    high = mid - 1;
                }

                else{
                    low = mid + 1;
                }
            }

            else if(target < nums[mid]){
                high = mid - 1;
            }

            else{
                low = mid + 1;
            }
        }

        return farthestIndex;
    }
}

/**

[5,7,8,8,8,8,8,10]
t=8



 */