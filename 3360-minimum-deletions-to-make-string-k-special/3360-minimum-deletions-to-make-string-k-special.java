class Solution {
    public int minimumDeletions(String word, int k) {
        int[] arr = new int[26];
        int letters=0;
        int ans=Integer.MAX_VALUE;
        char[] wordarr = word.toCharArray();

        for(char c: wordarr){
            if(arr[c-'a'] == 0){
                letters++;
            }
            arr[c-'a']++;
        }

        int[] starr = new int[letters];

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                starr[--letters] = arr[i];
            }
        }

        Arrays.sort(starr);


        // for(int i=0;i<starr.length;i++){
        //     System.out.println(starr[i]);
        // }
        
        int currans=0;

        for(int i=0;i<starr.length;i++){
            if(ans <= currans){
                break;
            }
            int temp=0;
            for(int j=starr.length-1;j>i;j--){
                if(starr[j] <= starr[i]){
                    break;
                }
                temp += Math.max(0,(starr[j]-starr[i])-k);
                // currans+=temp;
            }
            ans = Math.min(ans,currans+temp);
            // System.out.println(ans);
            currans += starr[i];
        }

        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }
}