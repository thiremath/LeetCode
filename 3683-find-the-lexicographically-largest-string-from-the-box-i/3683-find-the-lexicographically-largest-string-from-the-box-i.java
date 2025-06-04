class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        String ans = "";
        int temp = n-numFriends;

        if(numFriends == 1){
            return word;
        }

        for(int i=0;i<n;i++){
            // System.out.println(i);
            String curr = word.substring(i,Math.min(i+temp+1,n));
            // System.out.println(curr);
            if(curr.compareTo(ans) > 0){
                ans = curr;
            }
            // System.out.println(ans);
        }

        return ans;
    }
}