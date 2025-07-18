class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length/3;
        long ans = Long.MAX_VALUE;

        long[] min = new long[nums.length];
        long[] max = new long[nums.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long currsum=0;
        
        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            pq.add(curr);
            currsum+=curr;
            if(pq.size() > n){
                currsum-=pq.poll();
            }
            if(i >= n-1){
                min[i] = currsum;
            }
        }

        pq = new PriorityQueue<>();
        currsum=0;

        for(int i=nums.length-1;i>=0;i--){
            int curr = nums[i];
            pq.add(curr);
            currsum+=curr;
            if(pq.size() > n){
                currsum-=pq.poll();
            }
            if(i <= nums.length-n){
                max[i] = currsum;
            }
        }

        for(int i=n-1;i<nums.length-n;i++){
            ans = Math.min(ans,min[i]-max[i+1]);
        }

        return ans;
    }
}