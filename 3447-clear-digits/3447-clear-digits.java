class Solution {
    public String clearDigits(String s) {
        StringBuilder st = new StringBuilder("");

        for(char index : s.toCharArray()){

            if(index >= 48 && index <= 57){
                st.deleteCharAt(st.length() - 1);
            }

            else{

                st.append(index);
            }
        }

        return st.toString();
    }
}