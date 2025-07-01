class Solution {
    public int possibleStringCount(String word) {
        int ans=0;
        char[] arr = word.toCharArray();
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] == arr[i+1]){
                ans++;
            }
        }
        return ans+1;
    }
}