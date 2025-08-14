class Solution {
    public String largestGoodInteger(String num) {
        String res = "";
        char[] arr = num.toCharArray();

        for(int i=0;i<arr.length-2;i++){
            if(arr[i] == arr[i+1] && arr[i+1] == arr[i+2]){
                String curr = num.substring(i,i+3);
                if(res.equals("") || Integer.valueOf(curr) > Integer.valueOf(res)){
                    res = curr;
                }
            }
        }

        return res;
    }
}