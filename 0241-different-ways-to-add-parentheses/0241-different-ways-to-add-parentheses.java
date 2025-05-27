class Solution {
    HashMap<String,List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        char[] arr = expression.toCharArray();

        for(int i=0;i<arr.length;i++){

            char curr = arr[i];

            if(curr == '*' || curr == '-' || curr == '+'){

                String left = expression.substring(0,i);
                String right = expression.substring(i+1);

                List<Integer> leftans  = map.getOrDefault(left,diffWaysToCompute(left));
                List<Integer> rightans  = map.getOrDefault(right,diffWaysToCompute(right));

                for(Integer l: leftans){
                    for(Integer r: rightans){
                        int currelement = 0;
                        
                        switch(curr){
                            case '+' : currelement = l+r;
                                break;
                            case '-' : currelement = l-r;
                                break;
                            case '*' : currelement = l*r;
                                break;
                        }
                        ans.add(currelement);
                    }
                }

            }
        }

        if(ans.size() == 0){
            ans.add(Integer.valueOf(expression));
        }

        return ans;
    }
}