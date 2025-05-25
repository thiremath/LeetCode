class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] jumps = new int[n];

        for(int i=n-2;i>=0;i--){
            int curr=Integer.MAX_VALUE-1;
            for(int j=i+1;j<=nums[i]+i && j < n;j++){
                curr = Math.min(jumps[j],curr);
            }
            jumps[i] = 1+curr;
        }

        // for(int i=0;i<n;i++){
        //     System.out.print(jumps[i]+" ");
        // }

        return jumps[0];
    }
}