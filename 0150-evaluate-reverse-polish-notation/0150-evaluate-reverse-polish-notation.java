class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String token:tokens){

            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int b = st.pop();
                int a = st.pop();
                int currRes = 0;

                if(token.equals("+")){
                    currRes = a+b;
                }

                else if(token.equals("-")){
                    currRes = a-b;
                }

                else if(token.equals("*")){
                    currRes = a*b;
                }

                else{
                    currRes = a/b;
                }

                st.push(currRes);
            }

            else{
                st.push(Integer.valueOf(token));
            }
        }

        return st.pop();
    }
}