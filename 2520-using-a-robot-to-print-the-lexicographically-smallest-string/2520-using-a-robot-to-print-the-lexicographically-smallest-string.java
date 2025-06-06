class Solution {
    public String robotWithString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        StringBuilder ans = new StringBuilder("");
        int[] freq = new int[26];
        Stack<Character> st = new Stack<>();

        for(char c: arr){
            freq[c-'a']++;
        }

        for(char c: arr){
            freq[c-'a']--;
            st.push(c);
            while(st.size() > 0){
                char curr = st.peek();
                if(hasSmaller(freq,curr-'a')){
                    break;
                }
                ans.append(st.pop());
            }
        }

        return String.valueOf(ans);
    }

    public boolean hasSmaller(int[] freq, int freqIndex){
        for(int i=0;i<freqIndex;i++){
            if(freq[i] > 0){
                return true;
            }
        }
        return false;
    }
}