class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder("");
        int carry=0,sum=0;
        int i = a.length()-1;
        int j = b.length()-1;

        while(i >= 0 || j >= 0){
            sum = carry;

            if(i >= 0){
                sum += a.charAt(i--) - '0';
            }

            if(j >= 0){
                sum += b.charAt(j--) - '0';
            }

            ans.append(sum % 2) ;

            carry = sum<2 ? 0 : 1 ;
        }

        if(carry == 1){
            ans.append("1");
        }


        return ans.reverse().toString();
    }
}