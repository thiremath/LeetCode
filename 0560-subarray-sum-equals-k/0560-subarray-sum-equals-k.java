class Solution {
    public int subarraySum(int[] nums, int k) {
        /**
        
        [1,1,2,3,-2,1,4,7,9,10]
        k = 5

        [1,0,1,1,-5,3,3,3,2,1]

         */

        // [1,1,2,3,-2,1]

        // 0,1
        // 1,1
        // 2,1
        // 4,1

        HashMap<Integer,Integer> sumOccMap = new HashMap<>();
        int res=0;

        sumOccMap.put(0,1);
        int sum=0;

        for(int num:nums){
            sum += num;
            if(sumOccMap.containsKey(sum-k)){
                res += sumOccMap.get(sum-k);
            }
            sumOccMap.put(sum,sumOccMap.getOrDefault(sum,0)+1);
        }

        return res;

        //  if(nums.length==0) return 0;

        //  int res=0,n=nums.length;

        //  for(int i=0;i<n;i++){

        //     int sum = nums[i];
        //     if(sum==k) res++;

        //     for(int j=i+1;j<n;j++){
        //         sum += nums[j];
        //         if(sum==k) res++;
        //     }

        //  }

        //  return res;
    }
}