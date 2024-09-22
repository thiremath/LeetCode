class Solution {
    public int findKthLargest(int[] nums, int k) {
        for(int i = nums.length/2-1;i>=0;i--){
            maxHeapify(nums,i,nums.length);
        }
        for(int i=0;i<k-1;i++){
            nums[0] = nums[nums.length-i-1];
            maxHeapify(nums,0,nums.length-i-1);
        }
        return nums[0];
    }

    public void maxHeapify(int[] nums, int curr, int N){
        // int curr=0;
        while(curr*2+1 < N){

            if(curr*2+2 < N){
                if(nums[curr] < nums[curr*2+1] || nums[curr] < nums[curr*2+2]){
                    if(nums[curr*2+2] > nums[curr*2+1]){
                        swap(nums,curr,curr*2+2);
                        curr = curr*2+2;
                    }
                    else{
                        swap(nums,curr,curr*2+1);
                        curr = curr*2+1;
                    }
                }
                else{
                    break;
                }
            }

            else if(nums[curr] < nums[curr*2+1]){
                swap(nums,curr,curr*2+1);
                curr = curr*2+1;
            }

            else{
                break;
            }
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}