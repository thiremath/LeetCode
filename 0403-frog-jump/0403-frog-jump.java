class Solution {
    public boolean canCross(int[] stones) {
        // Integer[][] dp = new Integer[stones.length][2000000];
        Map<Integer,Set<Integer>> dp = new HashMap<>();
        return canCrossWorker(stones,0,0,dp);
        // return canCrossWorker(stones,0,0);
    }

    public boolean canCrossWorker(int[] stones, int index, int prev, Map<Integer,Set<Integer>> dp) {

    // public boolean canCrossWorker(int[] stones, int index, int prev) {

        if(index == stones.length-1){
            return true;
        }

        if(prev == 0){
            // return canCrossWorker(stones,1,1,dp);
            if(stones[1] == 1){
                return canCrossWorker(stones,1,1,dp);
            }
            return false;
        }

        if(dp.containsKey(index) && dp.get(index).contains(prev)){
            return false;            
        }

        int minJump = prev - 1;
        int maxJump = prev + 1;

        for(int i=index+1;i<stones.length;i++){

            if(stones[i] >= minJump+stones[index] && stones[i] <= maxJump+stones[index]){
                if(canCrossWorker(stones,i,Math.abs(stones[i]-stones[index]),dp)){
                // if(canCrossWorker(stones,i,Math.abs(stones[i]-stones[index]))){
                    return true;
                }
            }
        }

        if(!dp.containsKey(index)){
            dp.put(index,new HashSet<>());
        }

        dp.get(index).add(prev);

        return false;
    }
}