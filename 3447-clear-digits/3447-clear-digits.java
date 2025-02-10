class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder("");
        char[] arr = s.toCharArray();

        for(int index=0; index < arr.length; index++){

            if(arr[index] >= 48 && arr[index] <= 57){
                st.pop();
            }

            else{

                st.push(arr[index]);
            }
        }

        while(st.size() > 0){
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}