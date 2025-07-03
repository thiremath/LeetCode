class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        
        while(sb.length() < k){
            int len = Math.min(sb.length(),k);
            for(int i=0;i<len;i++){
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