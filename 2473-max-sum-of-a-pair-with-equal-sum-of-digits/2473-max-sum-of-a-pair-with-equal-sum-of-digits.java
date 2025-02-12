class Solution {
    public int maximumSum(int[] nums) {
        int ans = -1;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i: nums){

            int sum = calcSum(i);
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

    public int calcSum(int i){
        int ans=0;
        while(i > 0){
            ans+=(i%10);
            i/=10;
        }
        return ans;
    }

}