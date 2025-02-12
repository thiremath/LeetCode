class Solution {
    public int maximumSum(int[] nums) {
        int ans = -1;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i: nums){

            int sum = 0;
            int k = i;
            while(k > 0){
                sum+=(k%10);
                k/=10;
            }

            if(!map.containsKey(sum)){

                map.put(sum,i);
            }
            else{
                int temp = map.get(sum);
                ans = Math.max(ans,i+temp);
                if(i > temp){
                    map.put(sum,i);
                }
            }
        }

        return ans;
    }

}