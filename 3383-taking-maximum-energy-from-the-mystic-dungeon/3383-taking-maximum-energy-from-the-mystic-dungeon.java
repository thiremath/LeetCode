class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int ans=energy[energy.length-1];
        for(int i=energy.length-1;i>=0;i--){
            if(i+k<energy.length){
                energy[i] = energy[i]+energy[i+k];
            }
            ans = Math.max(ans,energy[i]);
        }
        return ans;
    }
}