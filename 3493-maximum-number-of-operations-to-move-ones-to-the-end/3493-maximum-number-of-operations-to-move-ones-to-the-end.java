class Solution {
    public int maxOperations(String s) {
        int oneCounts=0;
        int ans=0;
        char[] arr = s.toCharArray();
        int index=0;

        while(index<s.length()){
            if(arr[index]=='1'){
                oneCounts++;
                index++;
            }
            else{
                ans+=oneCounts;
                while(index<s.length() && arr[index]=='0'){
                    index++;
                }
            }
        }

        return ans;
    }
}