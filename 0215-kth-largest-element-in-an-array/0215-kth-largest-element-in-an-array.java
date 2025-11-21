class Solution {
    public int findKthLargest(int[] nums, int k) {
        /**
        [3,2,1,5,6,4]

        sorted nums-> 6,5,4,3,2,1
        
         */

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num: nums){
            minHeap.add(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}