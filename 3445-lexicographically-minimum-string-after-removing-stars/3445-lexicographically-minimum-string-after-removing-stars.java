class Solution {
    public String clearStars(String s) {
        Stack<Integer>[] st = new Stack[26];
        for(int i=0;i<26;i++){
            st[i] = new Stack<>();
        }
        StringBuilder ans = new StringBuilder("");

        char[] arr = s.toCharArray();

        for(int i=0;i<arr.length;i++){
            char c = arr[i];

            if(c != '*'){
                st[c-'a'].push(i);
            }

            else{
                for(int j=0;j<26;j++){
                    if(!st[j].isEmpty()){
                        arr[st[j].pop()] = '*';
                        break;
                    }
                }
            }
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i] != '*'){
                ans.append(arr[i]);
            }
        }

        return String.valueOf(ans);
    }
}