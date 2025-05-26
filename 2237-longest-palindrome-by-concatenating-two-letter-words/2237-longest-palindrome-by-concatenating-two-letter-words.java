class Solution {
    public int longestPalindrome(String[] words) {
        int ans = 0;
        HashMap<String,Integer> wordCountMap = new HashMap<>();

        int[] repeatedLetters = new int[26];

        for(String s: words){
            char a = s.charAt(0);
            char b = s.charAt(1);
            String ba = new StringBuilder(s).reverse().toString();
            // System.out.println(ba);

            if(a == b){
                if(repeatedLetters[a-'a'] > 0){
                    ans+=4;
                    repeatedLetters[a-'a']--;
                }
                else{
                    repeatedLetters[a-'a']++;
                }
            }

            else{

                if(wordCountMap.containsKey(ba) && wordCountMap.get(ba)>0){
                    ans+=4;
                    wordCountMap.put(ba,wordCountMap.get(ba)-1);
                }
                else{
                    if(!wordCountMap.containsKey(s) || wordCountMap.get(s) < 0){
                        wordCountMap.put(s,1);
                    }
                    else{
                        wordCountMap.put(s,wordCountMap.get(s)+1);
                    }
                }

            }
        }

        for(int i=0;i<26;i++){
            if(repeatedLetters[i] > 0){
                ans+=2;
                break;
            }
        }

        return ans;

    }
}