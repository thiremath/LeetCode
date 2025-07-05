class Solution {
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        int ans = -1;
        int occ = 1;

        for(int i=arr.length-1;i>=0;i--){

            if(arr[i] == ans){
                occ++;
            }

            else{
                if(occ == ans){
                    return ans;
                }
                ans = arr[i];
                occ = 1;
            }
        }

        return (occ == ans) ? ans : -1;
    }
}