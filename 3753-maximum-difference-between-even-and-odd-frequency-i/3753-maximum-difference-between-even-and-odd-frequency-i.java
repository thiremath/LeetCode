class Solution {
    public int maxDifference(String s) {
        int[] arr = new int[26];
        char[] st = s.toCharArray();

        for(char c: st){
            arr[c-'a']++;
        }

        int maxoddfq = 1;
        int minevenfq = s.length();

        for(int i=0;i<26;i++){
            // System.out.println(arr[i]);
            int curr = arr[i];
            if(curr != 0){
                if(curr % 2 != 0){
                    if(curr > maxoddfq){
                        maxoddfq = curr;
                    }
                }
                else{
                    if(curr < minevenfq){
                        minevenfq = curr;
                    }
                }
            }
        }

        return maxoddfq-minevenfq;
    }
}