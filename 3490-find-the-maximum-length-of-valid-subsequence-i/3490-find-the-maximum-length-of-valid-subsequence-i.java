class Solution {
    public int maximumLength(int[] nums) {
        int odd=0,even=0,alternate=0;
        boolean prev = ((nums[0]+1)%2)==0;

        for(int num:nums){
            boolean isOdd = (num%2==0);

            if(isOdd){
                odd++;
            }
            else{
                even++;
            }

            if(prev != isOdd){
                alternate++;
                prev = isOdd;
            }
        }
        return Math.max(alternate,Math.max(odd,even));
    }
}

