class Solution {
    public String clearDigits(String s) {
        StringBuilder st = new StringBuilder("");

        for(char index : s.toCharArray()){

            if(Character.isDigit(index)){
                st.deleteCharAt(st.length() - 1);
            }

            else{

                st.append(index);
            }
        }

        return st.toString();
    }
}