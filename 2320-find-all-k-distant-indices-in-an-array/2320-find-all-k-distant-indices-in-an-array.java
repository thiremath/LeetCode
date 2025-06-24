class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> keyIndices = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            int currI = nums[i];
            if(currI == key) {set.add(i);}
            for(int j=Math.min(nums.length-1,i+k);j>i;j--){
                if((currI == key || nums[j] == key)){
                    set.add(i);
                    set.add(j);
                }
            }
        }

        List<Integer> ans = new ArrayList<>(set);

        Collections.sort(ans);

        return ans;
    }
}