class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder("");
        int index=0,carry=0,tempa=0,tempb=0;

        while(a.length()-index > 0 && b.length()-index > 0){
            tempa = Integer.valueOf(String.valueOf(a.charAt(a.length()-index-1)));
            tempb = Integer.valueOf(String.valueOf(b.charAt(b.length()-index-1)));

            ans.append(Integer.toString((tempa+tempb+carry) % 2)) ;

            if(tempa+tempb+carry < 2){
                carry=0;
            }
            else{
                carry=1;
            }

            index++;
        }

        while(a.length()-index > 0 || b.length()-index > 0){
            tempa = 0;

            if(a.length()-index > 0){
                tempa = Integer.valueOf(String.valueOf(a.charAt(a.length()-index-1)));
            }

            else{
                tempa = Integer.valueOf(String.valueOf(b.charAt(b.length()-index-1)));
            }

            ans.append(Integer.toString((tempa+carry)%2)) ;
            
            if(tempa+carry < 2){
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