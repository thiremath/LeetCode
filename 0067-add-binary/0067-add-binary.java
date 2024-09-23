class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder("");
        int index=0,carry=0,temp=0;

        while(a.length()-index > 0 && b.length()-index > 0){
            temp = Integer.valueOf(String.valueOf(a.charAt(a.length()-index-1)))+ Integer.valueOf(String.valueOf(b.charAt(b.length()-index-1)))+carry;

            ans.append(Integer.toString(temp % 2)) ;

            if(temp < 2){
                carry=0;
            }
            else{
                carry=1;
            }

            index++;
        }

        while(a.length()-index > 0 || b.length()-index > 0){

            if(a.length()-index > 0){
                temp = Integer.valueOf(String.valueOf(a.charAt(a.length()-index-1)))+carry;
            }

            else{
                temp = Integer.valueOf(String.valueOf(b.charAt(b.length()-index-1)))+carry;
            }

            ans.append(Integer.toString(temp%2)) ;

            if(temp < 2){
                carry=0;
            }
            else{
                carry=1;
            }


            index++;

        }

        if(carry == 1){
            ans.append("1");
        }


        return ans.reverse().toString();
    }
}