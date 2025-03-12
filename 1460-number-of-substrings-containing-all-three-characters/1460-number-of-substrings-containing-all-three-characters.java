class Solution {

    public boolean checkocc(int[] occarr) {
        if(occarr[0] >= 1 && occarr[1] >= 1 && occarr[2] >= 1){
            return true;
        }
        return false;
    }
    
    public int numberOfSubstrings(String s) {
        int res=0,low=0,high=0;
        int[] occarr = new int[3];
        char[] arr = s.toCharArray();
        int n = arr.length;

        while(high < n){

            char c = arr[high];

            ++occarr[c-'a'];

            while(checkocc(occarr)){
                res+=(n-high);
                --occarr[arr[low]-'a'];
                low++;
            }
            
            high++;
        }

        return res;
    }
}

/**

abcabc

abc-
abca-
abcab-
abcabc-
bcabc
cabc
abc

 */