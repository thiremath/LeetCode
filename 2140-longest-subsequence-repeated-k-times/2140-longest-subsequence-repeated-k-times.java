class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] letter_arr = new int[26];
        char[] s_arr = s.toCharArray();
        List<StringBuilder> candidates = new ArrayList<>();
        Queue<StringBuilder> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder("");
        StringBuilder currans = new StringBuilder("");

        for(char c: s_arr){
            ++letter_arr[c-'a'];
        }

        for(int i=25;i>=0;i--){
            if(letter_arr[i] >= k){
                StringBuilder lett = new StringBuilder(String.valueOf((char)('a'+i)));
                // System.out.println(lett.toString());
                queue.add(lett);
                candidates.add(lett);
            }
        }

        while(!queue.isEmpty()){
            currans = queue.poll();
            if(ans.length() < currans.length()){
                ans = currans;
            }

            for(StringBuilder candidate: candidates){
                // System.out.println(currans.toString());
                currans.append(candidate);
                // System.out.println(currans.toString());
                if(isSubsequenceRepeatedK(s_arr,k,currans)){
                    // System.out.println("true");
                    queue.add(new StringBuilder(currans));
                }
                currans.deleteCharAt(currans.length() - 1);
                // System.out.println(currans.toString());
                // System.out.println("");
            }
        }

        return String.valueOf(ans);
    }

    public Boolean isSubsequenceRepeatedK(char[] s_arr,int k,StringBuilder currans){
        int index = 0;
        int sbLen = currans.length();
        int curr_k=0;

        for(char c: s_arr){
            if(c == currans.charAt(index)){
                if(++index == sbLen){
                    if(++curr_k == k){
                        return true;
                    }
                    index=0;
                }
            }
        }

        return false;
    }    

}