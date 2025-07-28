class Solution {
    int maxOr;
    int count;
    int curr;
    public int countMaxOrSubsets(int[] nums) {
        maxOr=0;count=0;curr=0;
        countMaxOrSubsetsWorker(nums,0);
        // System.out.println(maxOr+" "+count+" "+curr);
        return count;
    }

    public void countMaxOrSubsetsWorker(int[] nums, int index) {
        if(index == nums.length){
            if(maxOr<=curr && curr!=0){
                if(maxOr==curr){
                    count++;
                }
                else{
                    maxOr = curr;
                    count=1;
                }
            }
            return;
        }

        int temp = curr;
        curr |= nums[index];
        countMaxOrSubsetsWorker(nums,index+1);
        curr = temp;
        countMaxOrSubsetsWorker(nums,index+1);
    }
}