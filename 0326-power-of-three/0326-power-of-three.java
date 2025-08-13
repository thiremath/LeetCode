class Solution {
    public boolean isPowerOfThree(int n) {
        String nSt = Integer.toString(n, 3);
        System.out.println(nSt);
        boolean flag = false;
        if(n > 0){
            for(char c: nSt.toCharArray()){
                if(c != '1' && c != '0'){
                    return false;
                }
                if(c == '1'){
                    if(flag){
                        return false;
                    }
                    flag = true;
                }
            }
        }
        return flag;
    }
}