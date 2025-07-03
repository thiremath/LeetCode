class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        
        while(sb.length() < k){
            int len = sb.length();
            for(int i=0;i<Math.min(len,k);i++){
                sb.append(String.valueOf((char)(sb.charAt(i)+1)));
            }
        }

        return sb.charAt(k-1);
    }
}

/**

ab

abbc

abbcbccd

abbcbccdbccdcdde


......
 */