class Solution {
    public long countBadPairs(int[] nums) {
        long res=(long)nums.length*(nums.length-1)/2;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]-i)){
                map.put(nums[i]-i,1+map.get(nums[i]-i));
            }
            else{
                map.put(nums[i]-i,1);
            }
        }

        for (Map.Entry<Integer,Integer> mapElement : map.entrySet()) {
            long n = mapElement.getValue();
            if(n > 1){
                res-= n*(n-1)/2 ;
            }
        }

        return res;
    }
}

// 4,0,1,0

// 0,0,0,0,0