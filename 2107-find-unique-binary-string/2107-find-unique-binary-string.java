class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        int index;

        // traverse nums[] , add numbers in the set
        for(String s: nums){
            index=s.length()-1;
            int curr=0;
            for(char c: s.toCharArray()){
                if(c == '1'){
                    curr += Math.pow(2,index);
                }
                index--;
            }
            set.add(curr);
        }


        // iterate from 0 to nums.length and store it in number if not present in set
        int number=0;
        for(int i=0;i<=nums.length;i++){
            if(!set.contains(i)){
                // System.out.println("i= "+i);
                number = i;
                break;
            }
        }

        // convert decimal to binary and return
        StringBuilder ans = new StringBuilder("");
        // conversion

        index = nums.length;
        int temp = (int)Math.pow(2,nums.length-1);

        while(index-- != 0){

            // System.out.println( (number & (int)Math.pow(2,nums.length-1)) );

            if((number & temp) != 0){
                ans.append("1");
            }
            else{
                ans.append("0");
            }

            number = number << 1;
        }


        return String.valueOf(ans);
    }
}