class Solution {
    public int longestSubsequence(String s, int k) {
        int zeroLeft = 0;
        int value = 0;
        int power = 0;
        int taken = 0;

        char[] arr = s.toCharArray();

        for(char c: arr){
            if(c == '0'){
                zeroLeft++;
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '0') {
                taken++;
                zeroLeft--;
            } else {
                if (power < 31 && (value + (1 << power)) <= k) {
                    value += (1 << power);
                    taken++;
                } else {
                    break;
                }
            }
            power++;
        }

        return taken + zeroLeft;
    }   
}