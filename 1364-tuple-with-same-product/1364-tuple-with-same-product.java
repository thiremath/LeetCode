class Solution {
    public int tupleSameProduct(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int ans=0;

        for(int i=0;i<nums.length-1;i++){

            for(int j=i+1;j<nums.length;j++){

                if(map.containsKey(nums[i]*nums[j])){
                    
                    map.put(nums[i]*nums[j], 1 + map.get(nums[i]*nums[j]));
                    ans += map.get(nums[i]*nums[j]);
                }
                else{

                    map.put(nums[i]*nums[j], 0);
                }
            }
        }

        return ans*8;
    }
}