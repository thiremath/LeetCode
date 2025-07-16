class Solution {
    public int maximumLength(int[] nums) {
        int odd=0,alternate=0;
        boolean prev = !(((nums[0])%2)==0);

        for(int num:nums){
            boolean isOdd = (num%2==0);

            if(isOdd){
                odd++;
            }

            if(prev != isOdd){
                alternate++;
                prev = isOdd;
            }
        }
        return Math.max(alternate,Math.max(odd,nums.length-odd));
    }
}

