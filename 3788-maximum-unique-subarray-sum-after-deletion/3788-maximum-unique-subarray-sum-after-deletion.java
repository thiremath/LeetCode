class Solution {
    public int maxSum(int[] nums) {
        int ans=nums[0];

        Set<Integer> set = new HashSet<>(){{
            add(nums[0]);
        }};

        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            if(!set.contains(num)){
                set.add(num);
                ans = Math.max(ans,Math.max(num+ans,num));
            }
        }

        return ans;
    }
}