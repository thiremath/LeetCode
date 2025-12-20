class Solution {
    public String decodeString(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(char c:arr){

            if(c != ']'){
                stack.push(c);
            }

            else{

                StringBuilder currSt = new StringBuilder();

                while(!stack.isEmpty() && Character.isLetter(stack.peek())){
                    currSt.append(stack.pop());
                }

                System.out.println(currSt);

                stack.pop();

                int multiplyingNum = 0;
                int temp = 1;

                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    multiplyingNum += Integer.valueOf(String.valueOf(stack.pop()))*temp;
                    temp*=10;
                }

                System.out.println(multiplyingNum);

                while(multiplyingNum-- != 0){
                    for(int i=currSt.length()-1;i>=0;i--){
                        stack.push(currSt.charAt(i));
                    }
                }

                // stack.pop();
            }
        }

        while(!stack.isEmpty()){
            // System.out.println(stack.peek());
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}