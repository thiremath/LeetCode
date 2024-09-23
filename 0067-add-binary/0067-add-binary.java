class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder("");
        int index=0;
        int carry=0;

        while(a.length()-index > 0 && b.length()-index > 0){
            int tempa = Integer.valueOf(String.valueOf(a.charAt(a.length()-index-1)));
            int tempb = Integer.valueOf(String.valueOf(b.charAt(b.length()-index-1)));

            // System.out.println(tempa+" "+tempb);

            if(tempa+tempb+carry < 2){
                ans.append(Integer.toString(tempa+tempb+carry)) ;
                carry=0;
            }

            else if(tempa+tempb+carry == 2){
                ans.append("0");
                carry = 1;
            }

            else{
                ans.append("1");
                carry = 1;
            }

            index++;
        }

        while(a.length()-index > 0 || b.length()-index > 0){
            int temp=0;

            if(a.length()-index > 0){
                temp = Integer.valueOf(String.valueOf(a.charAt(a.length()-index-1)));
            }

            else{
                temp = Integer.valueOf(String.valueOf(b.charAt(b.length()-index-1)));
            }

            if(temp+carry < 2){
                ans.append(Integer.toString(temp+carry)) ;
                carry=0;
            }

            else if(temp+carry == 2){
                ans.append("0");
                carry = 1;
            }

            index++;

        }

        if(carry == 1){
            ans.append("1");
        }


        return ans.reverse().toString();
    }
}