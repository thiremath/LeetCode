class Solution {
    public int findBestValue(int[] arr, int target) {
        int low=0,high=Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE, diff = target+1;

        for(int curr:arr){
            high = Math.max(high,curr);
        }

        while(low <= high){
            int mid = low + (high-low) / 2;

            // System.out.println("mid = "+mid);

            int sumFound = findSum(arr,mid);

            // System.out.println("diff = "+Math.abs(target-sumFound));

            if(Math.abs(target-sumFound) <= diff){
                if(diff == Math.abs(target-sumFound) && mid < ans){
                    ans = mid;
                }
                else if(diff != Math.abs(target-sumFound)){
                    diff = Math.abs(target-sumFound);
                    ans = mid;
                }
            }

            if(sumFound == target){
                return mid;
            }

            else if(sumFound > target){
                high = mid - 1;
            }

            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public int findSum(int[] arr, int bound){
        int sum = 0;

        for(int curr:arr){
            if(curr <= bound){
                sum+=curr;
            }
            else{
                sum+=bound;
            }
        }

        // System.out.println("Sum = "+sum);

        return sum;
    }
}