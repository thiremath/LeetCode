class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int low=0,res=0;


        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            while(set.contains(curr)){
                set.remove(s.charAt(low++));
            }
            set.add(s.charAt(i));
            res = Math.max(res,i-low+1);
        }

        return res;
    }
}