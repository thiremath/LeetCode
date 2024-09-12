class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        // int ans=0;

        if(tokens.length == 1){
            return Integer.valueOf(tokens[0]);
        }

        for(int i=0;i<tokens.length;i++){

            if(tokens[i].equals("+") || tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){

                int b = st.pop();
                int a = st.pop();
                int temp = 0;

                if(tokens[i].equals("+")){
                    temp = a+b;
                }

                else if(tokens[i].equals("-")){
                    temp = a-b;
                }

                else if(tokens[i].equals("*")){
                    temp = a*b;
                }

                else{
                    temp = a/b;
                }

                st.push(temp);
            }

            else{
                st.push(Integer.valueOf(tokens[i]));
            }

        }

        return st.peek();
    }
}