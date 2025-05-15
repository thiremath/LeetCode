class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int prevgrp = -1;
        int len = groups.length;
        List<String> ans = new ArrayList<String>();

        for(int i=0;i<len;i++){
            int currgrp = groups[i];
            if(currgrp != prevgrp){
                ans.add(words[i]);
                prevgrp = currgrp;
            }
        }

        return ans;
    }
}